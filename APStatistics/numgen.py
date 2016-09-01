import random

result = []
for x in range(1,750):
	num = random.randint(1,750)
	while num in result:
		num = random.randint(1,750)
	result.append(num)	
print(result)

#after running in cmd or powershell through python numgen.py >> vals.txt
#edit in notepad++ and go to replace and choose ", " with \n and remember to use the extended function on bottom left
