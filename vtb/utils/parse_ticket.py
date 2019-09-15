#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# The above encoding declaration is required and the file must be saved as UTF-8

# from Process import *
from utils.Process import *


def get_goods_from_ticket(source_file):
    processor = Processor(AbbyyOnlineSdk())

    language = 'russian'
    output_format = 'txt'

    text = processor.recognize_file(source_file, language, output_format)
    with open('data.txt', 'w') as fout:
        fout.write(text)

    # for testing
    # DO NOT DELETE
    # with open('file.txt', 'r', encoding='utf-8') as fin:
    #     text = fin.read()

    lines = text.split('\n')

    goods = []
    top_key1 = 'Сайт'
    top_key2 = 'БЕЗ'
    bottom_key = 'СП.Р'
    for i, line in enumerate(lines):
        if line.find(bottom_key) != -1:
            shift = 0
            for j in range(i, -1, -1):
                if lines[j].find(top_key1) != -1 or lines[j].find(top_key2) != -1:
                    shift = j
                    break
            good = ''.join(lines[shift + 1: i:]).strip()
            box = good.split()
            x_ind = 0
            for word in box:
                if word == 'X':
                    break
                x_ind += 1
            title = ' '.join(box[0:x_ind - 1:])
            price = box[-1][1::]
            goods.append([title, price])
    return goods


# file1 = '/Users/turmezzz/Yandex.Disk.localized/Программирование/python/MoreTech/app/checks/1.png'
# file2 = '/Users/turmezzz/Yandex.Disk.localized/Программирование/python/MoreTech/app/checks/2.png'
# file3 = '/Users/turmezzz/Yandex.Disk.localized/Программирование/python/MoreTech/app/checks/3.png'
# file4 = '/Users/turmezzz/Yandex.Disk.localized/Программирование/python/MoreTech/app/checks/4.png'
#
# for title, price in get_goods_from_ticket(file4):
#     print(title, price)
















