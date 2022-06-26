//연안 날씨 데이터
//공공데이터 포털 API

var request = require('request');
var xml = require('xml-js'); //xml파일을 js로 변환
var ServiceKey = "=NYQp85bV4GjxauduBdSwaoZb3uT9jcgbECXr1WNuzKbPSx5%2Fdv7m%2B5gV6xRZk3yYt5M4dzOuspvMzSwrPgtd7g%3D%3D"

var url = 'http://apis.data.go.kr/1520635/OceanMensurationService/getOceanMesurationListcoo';
var queryParams = '?' + encodeURIComponent('serviceKey') + ServiceKey; /* Service Key*/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /* */
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /* */
queryParams += '&' + encodeURIComponent('OCEAN') + '=' + encodeURIComponent(''); /* */
queryParams += '&' + encodeURIComponent('sta_cde') + '=' + encodeURIComponent(''); /* */

request.get(url+queryParams, (err, res, body)=>{

    if(err){ //에러발생하면
        console.log(err); //에러 로그 찍어주기
    }else{

        if(res.statusCode == 200){ //응답코드가 200이라면
            const data  = body; // 데이터 받아와서
            var result = xml.xml2json(data, {compact: true, spaces: 4});
            console.log(result);
        }

        


    }
});