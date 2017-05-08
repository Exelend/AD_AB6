from myplotmod import dlread, myloglog_tn

names = ['normal', 'better10', 'better20', 'better30', 'better40', 'better50']

arr = dlread("move.txt", ";", True)
myloglog_tn(arr, 10, "moves", names)

arr = dlread("compare.txt", ";", True)
myloglog_tn(arr, 10, "compares", names)

arr = dlread("total.txt", ";", True)
myloglog_tn(arr, 10, "moves+compare", names)

arr = dlread("time.txt", ";", True)
myloglog_tn(arr, 10, "time [ms]", names)