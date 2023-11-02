def read_test_cases_from_txt(file_path):
    test_cases = []
    two_d_array = []
    INF = 999999999999
    V, E, A = None, None, None
    with open(file_path, 'r') as file:
        data = file.read().splitlines()
    V, E, A = map(int, data[0].split())
    for i in range(1,E+1):
         elements = list(map(int, data[i].strip().split()))
        # Append the elements to the 2D array
         two_d_array.append(elements)

    return two_d_array
test_cases = read_test_cases_from_txt("./Example_LAB7.txt")
for i in test_cases:
     print(i)