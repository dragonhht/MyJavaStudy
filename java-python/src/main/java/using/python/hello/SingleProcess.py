#!/usr/bin/python
# coding: utf-8

from time import sleep, ctime

'''
单进程事例
'''


def loop0():
    print '开始： ', ctime()
    sleep(4)
    print '结束:  ', ctime()


def loop1():
    print '开始： ', ctime()
    sleep(2)
    print '结束:  ', ctime()


def main():
    print '进程开始：', ctime()
    loop0()
    loop1()
    print '进程结束: ', ctime()

if __name__ == '__main__':
    main()