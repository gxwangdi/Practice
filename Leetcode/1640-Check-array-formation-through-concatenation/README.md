
The idea is simple and straightforward, pay attention to

while(cur < arr.length && j < pieces[i].length) {
                if (arr[cur]!=pieces[i][j]) {
                    return false;
                }
                cur++;
                j++;
            }

            vs

            while(cur++ < arr.length && j++ < pieces[i].length) {
                            if (arr[cur]!=pieces[i][j]) {
                                return false;
                            }
                        }

The later could incur OutOfBound error.
