import random

m = 100
n = 100

start = -5.0
end = 1000.0

matrix = [[random.uniform(start,end) for _ in range(m)] for _ in range(n)]

def write_matrix(outfile, matrix):
	for row in matrix:
		for num in row:
			outfile.write(format(num, "20.3f"))
		outfile.write("\n")


with open('input.txt', 'w') as outfile:
	outfile.write(str(m))
	outfile.write("  ")
	outfile.write(str(n))
	outfile.write("\n")
	write_matrix(outfile, matrix)
	write_matrix(outfile, matrix)



			


