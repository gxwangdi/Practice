
For tree problems, normally we use recursive approach, as per the tree
definition.

For each layer, we need two results, the first one is round edge, the second one
is half edge. Offer max(left.half_edge+right.half_edge, max(left.round_edge, right.round_edge)) as max round_edge,  max(left.half_edge, right.half_edge).
