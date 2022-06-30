/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function(s) {
    var deletions = 0;
    var freq = new Array(26).fill(0);
    const charCodeA = 97;
    for (var i = 0; i < s.length; i++) {
      freq[s.charCodeAt(i) - charCodeA]++;
    }
    
    var used = new Set();
    freq.forEach((i) => {
        if(i !== 0){
            let tempSize = used.size;
            used.add(i);
            let added = tempSize < used.size;
            if(!added){
                let nextEmpty = i - 1;
                while(used.has(nextEmpty) && nextEmpty !== 0){
                    nextEmpty--;
                }
                deletions += i - nextEmpty;
                used.add(nextEmpty);
            }
        }
    });
    return deletions;
};