import json
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