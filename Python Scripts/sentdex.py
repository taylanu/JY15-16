# -*- coding: utf-8 -*-
"""
Created on Sat May 28 21:43:36 2016

@author: taylanu
"""

import tensorflow.contrib.learn as skflow
from sklearn import datasets, metrics

iris = datasets.load_iris()

classifier = skflow.TensorFlowLinearClassifier(n_classes=3)

classifier.fit(iris.data, iris.target)
score = metrics.accuracy_score(iris.target, classifier.predict(iris.data))

print("Accuracy: %f" % score)