def local_maxima(seq):
    local_maxima_list = []
    i, j = 0,1

    if len(seq) == 0 :
        return local_maxima_list

    if len(seq) == 1 :
        return seq

    if len(seq) == 2:
        return seq[1:] if seq[1] >= seq[0] else seq[:1]

    while(j < len(seq) - 1):

        if seq[i] <= seq[j] and seq[j] > seq[j + 1]:
            local_maxima_list.append(seq[j])

        if i == 0 and seq[i] > seq[j]:
            local_maxima_list.append(seq[i])

        if seq[j] != seq[j+1]:
            i = j

        j += 1

    if seq[i] <= seq[j]:
        local_maxima_list.append(seq[j])



    return local_maxima_list




print(local_maxima([5,1,2,3,5,7,11,11,12,12,10,5,3,11,12,25,25,25,25,25,25,25,12,15,10,7,2,2,17]))

print(local_maxima([1,2,3,5,7,11,11,12,10,8,5,3,11,12,15,10,7,2,2]))