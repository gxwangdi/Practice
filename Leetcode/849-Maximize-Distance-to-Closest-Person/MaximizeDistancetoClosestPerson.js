/**
 * @param {number[]} seats
 * @return {number}
 */
var maxDistToClosest = function(seats) {
    let count = 0;
    let beforeStatus = -1
    let maxDis = 0;
    for (let i = 0; i < seats.length; i++) {
        if (seats[i] == 0) count++
            else {
                if (beforeStatus == -1 && count == 0) beforeStatus = seats[i];
                if (count % 2 == 1) {
                    if (beforeStatus == 1) maxDis = Math.max(Math.floor((count / 2) + 1), maxDis);
                    else {
                        maxDis = Math.max(count, maxDis);
                        beforeStatus = 1
                    }
                } else {
                    if (beforeStatus == 1) maxDis = Math.max(count / 2, maxDis);
                    else {
                        maxDis = Math.max(count, maxDis);
                        beforeStatus = 1
                    }
                }
                count = 0
            }
    };
    if (count > maxDis) maxDis = count
    return maxDis
};
