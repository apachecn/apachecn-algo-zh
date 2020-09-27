function replaceSpace(str)
{
    // write code here
    let strArr = str.split('');
    return strArr.reduce((pre, next) => {
        return pre + (next === ' ' ? '%20' : next)
    }, '');
}
module.exports = {
    replaceSpace : replaceSpace
};
