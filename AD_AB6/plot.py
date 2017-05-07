from myplotmod import dlread, myloglog_tn

arr = dlread("sample.txt", ";", True)
names = ['normal', 'better']
myloglog_tn(arr, 10, "quicksort", names)