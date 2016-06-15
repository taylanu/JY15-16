from sklearn import tree
features = [[140, "smooth"], [130, "smooth"], [150, "bumpy"], [170, "bumpy"]]
labels = ["apple", "apple", "orange", "orange"]
clf = tree.DecisionTreeClassifier()
clf = clf.fit(features, labels)

print(clf.predict([[160, 0]]))
