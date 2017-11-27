import numpy as np
import csv
import math
import peakutils

def peak(filename):
    with open('%s.csv' % filename) as csvfile:
        readCSV = csv.reader(csvfile, delimiter=',')
        x_all = []
        y_all = []
        z_all = []
        hard_brake = []

        for row in readCSV:
    	   x = float(row[1])
    	   y = float(row[2])
    	   z = float(row[3])
    	   x_all.append(x)
    	   y_all.append(y)
    	   z_all.append(z)

    length = len(z_all)
    z_slope = []
    for i in range(0, length):
        if i==0:
            z_slope.append(0)
        else:
            z_slope.append(z_all[i-1]-z_all[i])



    array1 = np.array(x_all)
    # indexes1 = peakutils.indexes(array1, thres=0.77, min_dist=50) # x soft/hard 0.85

    # print indexes1

    array2 = np.array(y_all)
    indexes = peakutils.indexes(array2, thres=0.45, min_dist=30) #y 0.77 / 0.68
    indexes = indexes + 1

    print indexes

    array3 = np.array(z_slope)
    # indexes3 = peakutils.indexes(array3, thres=0.77, min_dist=50) #z soft/hard 0.76

    # print indexes3

    return array1, array2, array3, indexes


def tenPoints(array, indexes):
    dataRange = []
    stdDev = []
    for i in indexes:
        p = int(i) - 1
        if p+5 < len(array):
            average = (array[p-5] + array[p-4] + array[p-3] + array[p-2] + array[p-1] + array[p] + array[p+1] + array[p+2] + array[p+3] + array[p+4] + array[p+5])/11
            ten = []
            dev = 0
            for j in range(0, 12):
                a = array[j+p-5]
                dev = dev + (a-average)**2
                ten.append(a)
            r = max(ten) - min(ten)
            dev = math.sqrt(dev/10)
            dataRange.append(r)
            stdDev.append(dev)

    return dataRange, stdDev

if __name__ == "__main__":
    filename = raw_input('Enter the file name: ')
    array1, array2, array3, indexes = peak(filename)
    dataRange1, stdDev1 = tenPoints(array1, indexes)
    dataRange2, stdDev2 = tenPoints(array2, indexes)
    dataRange3, stdDev3 = tenPoints(array3, indexes)
    with open('train.csv', 'a') as csvfile:
        writeCSV = csv.writer(csvfile, delimiter=',')
        writeCSV.writerow([])
        length = len(dataRange1)
        for k in range(0,length):
            if dataRange2[k] > 0.2:
                writeCSV.writerow([indexes[k], dataRange1[k], stdDev1[k], dataRange2[k], stdDev2[k], dataRange3[k], stdDev3[k], 0])


