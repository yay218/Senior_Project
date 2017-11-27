# library for plotting
from matplotlib import pyplot as plt
from sklearn.neighbors import KNeighborsClassifier
import pandas as pd
import numpy as np
import csv

training = pd.read_csv('brake_train_6feature_new.csv')
test = pd.read_csv('brake_test_6feature_new.csv')

training_features = training.iloc[:, :-1]
training_label = training.iloc[:, -1]

test_features = test.iloc[:, :-1]
test_label = test.iloc[:, -1]

accuracy_all = []
for i in range(1, 129):
	knn = KNeighborsClassifier(n_neighbors=i)
	knn.fit(training_features, training_label)
	predict_test = knn.predict(test_features)

	count = 0
	for i in range(0,94):
		if predict_test[i] == test_label[i]:
			count = count + 1
	accuracy = count/float(94)
	accuracy_all.append(accuracy)

print max(accuracy_all)