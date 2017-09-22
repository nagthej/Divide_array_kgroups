# Divide_array_kgroups
Trying to find a group with list of numbers where the sum of each group should be equal

From the given permutaions of numbers, we are trying to find a group where the sum in all groups should be equal  
Algorithm for the problem: If we have to divide into k groups, if the total sum is 'sum', 
then each groups sum should be (sum / k). so here we are trying to find the groups. 
so basically if we generate all the permutations of an array, 
and for each array start putting elements in one group 
and start a new group as soon as the sum reaches (sum / k) 

If the function returns true for even one of the permutation then the answer is true 
(Yes It is possible to divide into k groups).
