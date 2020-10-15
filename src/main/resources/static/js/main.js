//后端IP地址
const url = "https://www.fanzhoujixie.com/"

/**
 * axios Get请求
 *
 * @param interface     接口名称
 * @param params        传递给后端的参数
 * @param thenFunc      成功回调函数
 * @param catchFunc     捕获到异常回调函数
 */
let requestGet = function (interface, params, thenFunc, catchFunc) {
    axios.get(url + interface, {params: params}).then(thenFunc).catch(catchFunc);
}

/**
 * axios Post请求
 *
 * @param interface     接口名称
 * @param params        传递给后端的参数
 * @param thenFunc      成功回调函数
 * @param catchFunc     捕获到异常回调函数
 */
let requestPost = function (interface, params, thenFunc, catchFunc) {
    axios.post(url + interface, params).then(thenFunc).catch(catchFunc);
}

/**
 * el-autocomplete 自动补全输入框数据查询
 *
 * @param interface     接口名称
 * @param queryString   查询字符串
 * @param callback      el-autocomplete的回调函数
 */
let autoCompleteQuery = function (interface, queryString, callback) {
    requestGet(interface, {queryString: queryString}, function (response) {
        let result = response.data;
        let dataArray = [];
        if (result.length != 0) {
            for (let i = 0; i < result.length; i++) {
                dataArray[i] = {value: result[i]};
            }
            callback(dataArray);
        } else {
            callback([{value: "未查询到相关数据"}]);
        }
    }, function (error) {
        callback([{value: "网络异常"}]);
    });
}

/**
 * 表单验证
 *
 * @param vueObj        vue实例对象
 * @param formName      表单名称
 * @param successFunc   表单验证成功回调函数
 */
let formValidation = function (vueObj, formName, successCallBack) {
    vueObj.$refs[formName].validate(valid => {
        if (valid) {
            successCallBack();
        }
    });
}

/**
 * 修改电话号码
 *
 * @param vueObj        vue实例对象
 * @param formName      表单名字（进行表单验证）
 * @param params        向后端传递的参数
 * @param successFunc   成功回调函数
 * @param failFunc      失败回调函数
 * @param catchFunc     捕获到异常回调函数
 */
let updateTelephone = function (params, successFunc, failFunc, catchFunc) {
    requestGet("updateTelephone", params, response => {
        let result = response.data;
        if (result == 1) {
            successFunc();
        } else {
            failFunc();
        }
    }, catchFunc);
}

/**
 * 查询数据总数
 *
 * @param interface     接口名称
 * @param params        向后端传递的参数
 * @param successFunc   成功回调函数，回调参数为查询到的结果
 * @param catchFunc     失败回调函数
 */
let queryDataNum = function (interface, params, successFunc, catchFunc) {
    requestGet(interface, params, response => {
        successFunc(response.data);
    }, catchFunc);
}

/**
 *根据页码查询数据
 *
 * @param interface     接口名称
 * @param params        向后端传递的参数
 * @param successFunc   成功回调函数，回调参数为查询到的结果
 * @param catchFunc     失败回调函数
 */
let queryDataByPageNum = function (interface, params, successFunc, catchFunc) {
    requestGet(interface, params, response => {
        successFunc(response.data);
    }, catchFunc);
}

let dateFormat = function (fmt, date) {
    let ret;
    let opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
    };
    for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
        ;
    }
    ;
    return fmt;
}

/**
 * 获取昨天日期
 * @returns {string}
 */
let getYesterday = function () {
    let time = (new Date()).getTime() - 24 * 60 * 60 * 1000;
    let yesterday = new Date(time);
    let year = yesterday.getFullYear();
    let month = yesterday.getMonth() + 1;
    let day = yesterday.getDate();

    if (month < 10) month = '0' + month;
    if (day < 10) day = '0' + day;

    return year + '-' + month + '-' + day;
}
