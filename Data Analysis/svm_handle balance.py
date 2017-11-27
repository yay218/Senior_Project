from sklearn import svm
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

def svm_model():
	training_org = pd.read_csv('brake_train_6feature_new.csv')
	test = pd.read_csv('brake_test_6feature_new.csv')

	train_soft = training_org.iloc[range(0, 292), :].sample(75)
	train_hard = training_org.iloc[range(292, 360), :].sample(19)
	frames = [train_soft, train_hard]
	training = pd.concat(frames)

	training_features = training.iloc[:, :-1]
	training_label = training.iloc[:, -1]



	test_features = test.iloc[:, :-1]
	test_label = test.iloc[:, -1]

	C = 1.0  # SVM regularization parameter
	
	'''
	# SVC with linear kernel
	svc = svm.SVC(kernel='linear', C=C).fit(training_features, training_label)
	predict_svc = svc.predict(test_features)
	count = 0
	for i in range(0,94):
		if predict_svc[i] == test_label[i]:
			count = count + 1
	svc_accuracy = count/float(94)
	#print "Accuracy for svc_accuracy is", svc_accuracy
	'''

	# LinearSVC (linear kernel)
	lin_svc = svm.LinearSVC(C=C).fit(training_features, training_label)
	predict_lin_svc = lin_svc.predict(test_features)
	count = 0
	for i in range(0,94):
		if predict_lin_svc[i] == test_label[i]:
			count = count + 1
	lin_svc_accuracy = count/float(94)
	return lin_svc_accuracy
	#print "Accuracy for lin_svc_accuracy is", lin_svc_accuracy

'''
	# SVC with RBF kernel
	rbf_svc = svm.SVC(kernel='rbf', gamma=0.7, C=C).fit(training_features, training_label)
	predict_rbf_svc = rbf_svc.predict(test_features)
	count = 0
	for i in range(0,94):
		if predict_rbf_svc[i] == test_label[i]:
			count = count + 1
	rbf_svc_accuracy = count/float(94)
	#print "Accuracy for rbf_svc_accuracy is", rbf_svc_accuracy


	# SVC with polynomial (degree 3) kernel
	poly_svc = svm.SVC(kernel='poly', degree=3, C=C).fit(training_features, training_label)
	predict_poly_svc = poly_svc.predict(test_features)
	count = 0
	for i in range(0,94):
		if predict_poly_svc[i] == test_label[i]:
			count = count + 1
	poly_svc_accuracy = count/float(94)
	#print "Accuracy for poly_svc_accuracy is", poly_svc_accuracy
	'''



if __name__ == "__main__":
	lin_svc_accuracy_all = []
	for i in range(0, 1000):
		lin_svc_accuracy = svm_model()
		lin_svc_accuracy_all.append(lin_svc_accuracy)

	print "Max accuracy after 1000 runs is", max(lin_svc_accuracy_all)
	print "Min accuracy after 1000 runs is", min(lin_svc_accuracy_all)
	print "Average accuracy after 1000 runs is", sum(lin_svc_accuracy_all) / float(len(lin_svc_accuracy_all))

