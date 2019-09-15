#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# The above encoding declaration is required and the file must be saved as UTF-8

import argparse
import os
import time

from utils.AbbyyOnlineSdk import *


class Processor:

	def __init__(self, abbyy):
		self.processor = abbyy

	def setup_processor(self):
		if "ABBYY_APPID" in os.environ:
			self.processor.ApplicationId = os.environ["ABBYY_APPID"]

		if "ABBYY_PWD" in os.environ:
			self.processor.Password = os.environ["ABBYY_PWD"]

		# Proxy settings
		if "http_proxy" in os.environ:
			proxy_string = os.environ["http_proxy"]
			# print("Using http proxy at {}".format(proxy_string))
			self.processor.Proxies["http"] = proxy_string

		if "https_proxy" in os.environ:
			proxy_string = os.environ["https_proxy"]
			# print("Using https proxy at {}".format(proxy_string))
			self.processor.Proxies["https"] = proxy_string

	def recognize_file(self, file_path, language, output_format):
			settings = ProcessingSettings()
			settings.Language = language
			settings.OutputFormat = output_format
			task = self.processor.process_image(file_path, settings)
			if task is None:
				# print("Error")
				return
			if task.Status == "NotEnoughCredits":
				# print(
				# 	"Not enough credits to process the document. Please add more pages to your application's account.")
				return

			# print("Id = {}".format(task.Id))
			# print("Status = {}".format(task.Status))

			# Wait for the task to be completed
			# print("Waiting..")
			# Note: it's recommended that your application waits at least 2 seconds
			# before making the first getTaskStatus request and also between such requests
			# for the same task. Making requests more often will not improve your
			# application performance.
			# Note: if your application queues several files and waits for them
			# it's recommended that you use listFinishedTasks instead (which is described
			# at https://ocrsdk.com/documentation/apireference/listFinishedTasks/).

			while task.is_active():
				time.sleep(5)
				# print(".")
				task = self.processor.get_task_status(task)

			# print("Status = {}".format(task.Status))

			if task.Status == "Completed":
				if task.DownloadUrl is not None:
					# self.processor.download_result(task, result_file_path)
					# print("Result was written to {}".format(result_file_path))
					return self.processor.get_raw_text(task)
			else:
				print("Error processing task")


