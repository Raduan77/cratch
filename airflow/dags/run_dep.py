import datetime as dt
from airflow import DAG
from airflow.operators.python_operator import PythonOperator

import time
import pandas as pd

auth = "key=AAAAgpKnM6o:APA91bE-9JdZsCv_oXZcwCQRwAat-cdZwZ7XiNgF5jNaNJ4sNOawojS9BBQtAyByCKyPiEZp7oty3E3zd94UoVStkxQBlpHkTYE5yNgFUkI6qbocaRPVFbcCXrEcs7VqvOZnlBVMAQ-a"
url = "https://fcm.googleapis.com/fcm/send"
ids = "fMeUgSHX0OY:APA91bEA7DXIFX89N-bUvf4PQ8-zzD4oOa1ZtePm76hTsIWCAMr1OoJKS2wv68OGe8F5t-f5JaQNeXJ1W-q_nSuETwrA5XM7In7LRBl9SeWFDjJQULOhYqEGYK-CashJdkWonh5FI-Ii"
msg = "DEP"
title = 'DEP'
import requests

def push_notification(ids, url, auth, msg, title):
    headers = {
    'Authorization': auth,
    'Content-Type': "application/json",
    'cache-control': "no-cache",
    'Postman-Token': "e3687812-bf20-4ecc-a40e-d13ba4bc5fa5"
    }
    payload = '{"registration_ids":["' + ids + '"],"data":{"message":"' + msg + '","title":"' + title + '","subtitle":"This is a subtitle. subtitle","tickerText":"Ticker text here...Ticker text here...Ticker text here","vibrate":1,"sound":1,"largeIcon":"large_icon","smallIcon":"small_icon"}}'
    response = requests.request("POST", url, data=payload, headers=headers)
    return response

def f():
    data_df = pd.read_csv('data.csv')
    for i in data_df:
        push_notification(data_df.iloc[0]['android_id'], url, auth, 'dfdf', title)

default_args = {
    'owner': 'airflow',
    'start_date': dt.datetime(2019, 9, 15, 10, 00, 00),
    'concurrency': 1, 
    'retries': 0
}

with DAG('test',
         default_args=default_args,
         max_active_runs = 1,
         schedule_interval= '*/30 * * * *',
         ) as dag:

    check_scheduler = PythonOperator(task_id = 'cheking',
                                    python_callable = f)