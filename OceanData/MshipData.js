//모선별 관제 현황

var request = require('request');
var convert = require("xml-js");

var url = 'http://apis.data.go.kr/1192000/CntlVssl2/Info';
var ServiceKey = "=NYQp85bV4GjxauduBdSwaoZb3uT9jcgbECXr1WNuzKbPSx5%2Fdv7m%2B5gV6xRZk3yYt5M4dzOuspvMzSwrPgtd7g%3D%3D"
var queryParams = '?' + encodeURIComponent('serviceKey') + ServiceKey; /* Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /* */
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /* */
queryParams += '&' + encodeURIComponent('prtAgCd') + '=' + encodeURIComponent('20'); /* */
queryParams += '&' + encodeURIComponent('sde') + '=' + encodeURIComponent('20170209'); /* */
queryParams += '&' + encodeURIComponent('ede') + '=' + encodeURIComponent('20170209'); /* */
queryParams += '&' + encodeURIComponent('clsgn') + '=' + encodeURIComponent('9VHZ8'); /* */

request.get(url + queryParams, (err, res, body)=>{

if(err){
    console.log(err);
}else{

    if(res.statusCode == 200){
        const data = body;
        var result = convert.xml2json(data, {compact : true , spaces : 4});
        console.log(result);
       }
  }

});