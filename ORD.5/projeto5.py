def merge(llist, rlist):
  final = []
  
  while llist or rlist:
    if len(llist) and len(rlist):
      
      if llist[0] < rlist[0]:
        final.append(llist.pop(0))
      
      else:
        final.append(rlist.pop(0))
               
    if not len(llist):
      if len(rlist): final.append(rlist.pop(0))

    if not len(rlist):
      if len(llist): final.append(llist.pop(0))
  
  return final

def merge_sort(list):
  
  if len(list) < 2: return list
    
  mid = int(len(list) / 2)
  
  return merge(merge_sort(list[:mid]), merge_sort(list[mid:]))


def quick_sort(l):
  if l:
    left = [x for x in l if x < l[0]]
    right = [x for x in l if x > l[0]]
    
    if len(left) > 1:
      left = quick_sort(left)
    if len(right) > 1:
      right = quick_sort(right)
    
    return left + [l[0]] * l.count(l[0]) + right
  return []

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

def get_list(n):

  values = []
  n = n.replace('\t', ' ')
  n = n.replace('\n', ' ')
  for i in n.split(' '):
      if i != '':
          values.append(int(i))
  return values

Z = input("Para inserir caminho de arquivo digite 1, para insetir lista digite 2:")

if(int(Z) == 1):
  A = input("Digite 1 para usar MergeSort e 2 para usar QuickSort:")

  if(int(A) == 1):
    B = input("Digite o caminho do arquivo:")
    lista = get_process(B)
    print(merge_sort(lista))
  else:
    B = input("Digite o caminho do arquivo:")
    lista = get_process(B)
    print(quick_sort(lista))
else:
  A = input("Digite 1 para usar MergeSort e 2 para usar QuickSort:")

if(int(A) == 1):
  B = input("Digite a lista a ser ordenada:")
  lista = get_list(B)
  print(merge_sort(lista))
else:
  B = input("Digite a lista a ser ordenada:")
  lista = get_list(B)
  print(quick_sort(lista))



