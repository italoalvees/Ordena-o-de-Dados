def selection(num , tam):
	for i in range(tam-1):
		mi = i
		for j in range(i+1,tam):
			if(num[j] < num[mi]):
				mi =  j
		if(num[i]!= num[mi]):
			aux = num[i]
			num[i] = num[mi]
			num[mi] = aux

	return num

def insertion(lista):
  	for i in range(1, len(lista)):
  		chave = lista[i]
  		k = i
  		while k > 0 and chave < lista[k-1]:
  			lista[k] = lista[k-1]
  			k -= 1
  		lista[k] = chave

  	return lista

def get_process(filename):

    values = []

    with open(filename, 'r') as r:
        for line in r:
            line = line.replace('\t', ' ')
            line = line.replace('\n', ' ')
            for i in line.split(' '):
                if i != '':
                    values.append(int(i))

    return values

A = get_process("num.10000.3.in")[1:]


x = insertion(A)
print(x)	
