import numpy as np
import csv

def smooth(input_file_name, output_file_name):
    with open('%s.csv' % input_file_name) as csvfile:
        readCSV = csv.reader(csvfile, delimiter=',')
        t_all = []
        x_all = []
        y_all = []
        z_all = []

        for row in readCSV:
            t = row[0]
            x = float(row[1])
            y = float(row[2])
            z = float(row[3])
            t_all.append(t)
            x_all.append(x)
            y_all.append(y)
            z_all.append(z)

    x_avg = 0
    y_avg = 0
    z_avg = 0

    x_modified = []
    y_modified = []
    z_modified = []
    t_modified = []

    start = 0
    end = 0

    for i in range(0, 10):
        if t_all[i][:-2] == t_all[0][:-2]:
            start += 1

    end = start + 10
    len1 = len(t_all)

    while True:
        t_modified.append(t_all[start])
        for j in range(start, end):
            x_avg = x_avg + x_all[j]
            y_avg = y_avg + y_all[j]
            z_avg = z_avg + z_all[j]
        
        x_avg = x_avg/10
        y_avg = y_avg/10
        z_avg = z_avg/10

        x_modified.append(x_avg)
        y_modified.append(y_avg)
        z_modified.append(z_avg)

        x_avg = 0
        y_avg = 0
        z_avg = 0

        start = start + 10
        end = end + 10
        if end > len1:
            break

    len2 = len(x_modified)

    with open('%s.csv' % output_file_name, 'wb') as csvfile:
        writeCSV = csv.writer(csvfile, delimiter=',')
        for i in range(0,len2):
            x_val = str(x_modified[i])
            y_val = str(y_modified[i])
            z_val = str(z_modified[i])
            t_val = t_modified[i]
            writeCSV.writerow([t_val, x_val, y_val, z_val])
    return

if __name__ == "__main__":
    input_file_name = raw_input('Enter the input file name: ')
    output_file_name = raw_input('Enter the output file name: ')
    smooth(input_file_name, output_file_name)






