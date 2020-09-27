function Find(target, array)
{
    // write code here
    const num_row = array.length;
    for(let i=0; i<num_row;i++) {
        if(array[i].indexOf(target) > -1) {
            return true
        }
    }
}
module.exports = {
    Find : Find
};
