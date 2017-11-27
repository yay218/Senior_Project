from sklearn import svm
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


training = pd.read_csv('brake_train_6feature_new.csv')
test = pd.read_csv('brake_test_6feature_new.csv')

training_features = training.iloc[:, :-1]
training_label = training.iloc[:, -1]

test_features = test.iloc[:, :-1]
test_label = test.iloc[:, -1]

C = 1.0  # SVM regularization parameter
 
# SVC with linear kernel
svc = svm.SVC(kernel='linear', C=C).fit(training_features, training_label)
predict_svc = svc.predict(test_features)
count = 0
for i in range(0,94):
	if predict_svc[i] == test_label[i]:
		count = count + 1
svc_accuracy = count/float(94)
print "Accuracy for svc_accuracy is", svc_accuracy

'''
# LinearSVC (linear kernel)
lin_svc = svm.LinearSVC(C=C).fit(training_features, training_label)
predict_lin_svc = lin_svc.predict(test_features)
count = 0
for i in range(0,500):
	if predict_lin_svc[i] == test_label[i]:
		count = count + 1
lin_svc_accuracy = count/float(500)
print "Accuracy for lin_svc_accuracy is", lin_svc_accuracy


# SVC with RBF kernel
rbf_svc = svm.SVC(kernel='rbf', gamma=0.7, C=C).fit(training_features, training_label)
predict_rbf_svc = rbf_svc.predict(test_features)
count = 0
for i in range(0,500):
	if predict_rbf_svc[i] == test_label[i]:
		count = count + 1
rbf_svc_accuracy = count/float(500)
print "Accuracy for rbf_svc_accuracy is", rbf_svc_accuracy

# SVC with polynomial (degree 3) kernel
poly_svc = svm.SVC(kernel='poly', degree=3, C=C).fit(training_features, training_label)
predict_poly_svc = poly_svc.predict(test_features)
count = 0
for i in range(0,500):
	if predict_poly_svc[i] == test_label[i]:
		count = count + 1
poly_svc_accuracy = count/float(500)
print "Accuracy for poly_svc_accuracy is", poly_svc_accuracy
'''


