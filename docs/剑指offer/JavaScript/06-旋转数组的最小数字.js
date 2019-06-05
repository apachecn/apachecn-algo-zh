function minNumberInRotateArray(rotateArray)
{
    // write code here
    if (rotateArray.length === 0) {
        return 0;
    } else {
        return Math.min.apply(null, rotateArray)
    }
}
module.exports = {
    minNumberInRotateArray : minNumberInRotateArray
};
