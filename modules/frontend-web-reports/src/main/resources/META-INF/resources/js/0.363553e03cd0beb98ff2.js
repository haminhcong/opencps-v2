webpackJsonp([0],{453:function(t,e,a){var n=a(184)(a(457),a(468),null,null);t.exports=n.exports},457:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a(461),o=a.n(n),r=a(81),i=a(466),s=a.n(i),u=a(186);a.n(u);e.default={props:["index","id"],components:{"vue-friendly-iframe":s.a},data:function(){return{isCallBack:!0,fromDate:null,menufromDate:!1,fromDateFormatted:null,toDate:null,menutoDate:!1,toDateFormatted:null,danhSachBaoCaos:[],years:[{value:"",name:"Lọc theo năm"},{value:"2017",name:"năm 2017"},{value:"2018",name:"năm 2018"},{value:"2019",name:"năm 2019"}],year:(new Date).getFullYear()+"",months:[{value:"0",name:"Cả năm"},{value:"1",name:"tháng 1"},{value:"2",name:"tháng 2"},{value:"3",name:"tháng 3"},{value:"4",name:"tháng 4"},{value:"5",name:"tháng 5"},{value:"6",name:"tháng 6"},{value:"7",name:"tháng 7"},{value:"8",name:"tháng 8"},{value:"9",name:"tháng 9"},{value:"10",name:"tháng 10"},{value:"11",name:"tháng 11"},{value:"12",name:"tháng 12"}],month:(new Date).getMonth()+1+"",agencyLists:[],govAgency:null,danhSachBaoCao:[],pdfBlob:null,documentTYPE:"REPORT_01"}},computed:{loadingMenuConfigToDo:function(){return this.$store.getters.loadingMenuConfigToDo}},created:function(){var t=this;t.$nextTick(function(){t.danhSachBaoCao=t.loadingMenuConfigToDo;var e=t.$router.history.current.query;e.hasOwnProperty("fromDate")?t.fromDateFormatted=e.fromDate:t.fromDateFormatted=new Date((new Date).getFullYear(),(new Date).getMonth(),(new Date).getDate()).toLocaleDateString("vi-VN"),e.hasOwnProperty("toDate")?t.toDateFormatted=e.toDate:t.toDateFormatted=new Date((new Date).getFullYear(),(new Date).getMonth(),(new Date).getDate()+3).toLocaleDateString("vi-VN"),t.doPrintReport()})},updated:function(){var t=this;t.$nextTick(function(){if(t.isCallBack){t.isCallBack=!1,t.danhSachBaoCao=t.loadingMenuConfigToDo;var e=(t.$router.history.current.params,t.$router.history.current.query);t.isCallBack&&(t.isCallBack=!1,console.log("-----------------"),console.log(t.danhSachBaoCao),console.log(t.index),t.documentTYPE=t.danhSachBaoCao[t.index].document,e.hasOwnProperty("fromDate")?t.fromDateFormatted=e.fromDate:t.fromDateFormatted=new Date((new Date).getFullYear(),(new Date).getMonth(),(new Date).getDate()).toLocaleDateString("vi-VN"),e.hasOwnProperty("toDate")?t.toDateFormatted=e.toDate:t.toDateFormatted=new Date((new Date).getFullYear(),(new Date).getMonth(),(new Date).getDate()+3).toLocaleDateString("vi-VN"))}})},watch:{$route:function(t,e){var a=this;t.query;a.doPrintReport()},fromDate:function(t){this.fromDateFormatted=this.formatDate(this.fromDate)},toDate:function(t){this.toDateFormatted=this.formatDate(this.toDate)}},methods:{doPrintReport:function(){var t=this;t.documentTYPE=t.danhSachBaoCao[t.index].document;var e={document:t.documentTYPE,year:t.year,month:t.month,fromDate:t.fromDateFormatted,toDate:t.toDateFormatted};t.pdfBlob=null,t.$store.dispatch("getAgencyReportLists",e).then(function(e){var a={};if(null!==e&&void 0!==e){a=e,"REPORT_01"===t.documentTYPE?(a.year=t.year,a.month=t.month):(a.fromDate=t.fromDateFormatted,a.toDate=t.toDateFormatted);var n={document:t.documentTYPE,data:a};t.$store.dispatch("doStatisticReportPrint",n).then(function(e){t.pdfBlob=e})}else alert("Không tìm thấy dữ liệu báo cáo.")})},changeYear:function(t){var e=this;e.year=t,r.a.push({path:"/bao-cao/"+e.index,query:{year:e.year,month:e.month,fromDate:e.fromDate,toDate:e.toDate}})},changeMonth:function(t){var e=this;e.month=t,r.a.push({path:"/bao-cao/"+e.index,query:{year:e.year,month:e.month,fromDate:e.fromDate,toDate:e.toDate}})},changeGov:function(t){var e=this;e.govAgency=t,r.a.push({path:"/bao-cao/"+e.index,query:{year:e.year,month:e.month,fromDate:e.fromDate,toDate:e.toDate}})},changeFromDate:function(){var t=this;t.menufromDate=!1,t.fromDateFormatted=t.formatDate(t.fromDate),r.a.push({path:"/bao-cao/"+t.index,query:{year:t.year,month:t.month,fromDate:t.fromDateFormatted,toDate:t.toDateFormatted}})},changeToDate:function(){var t=this;t.menutoDate=!1,t.toDateFormatted=t.formatDate(t.toDate),r.a.push({path:"/bao-cao/"+t.index,query:{year:t.year,month:t.month,fromDate:t.fromDateFormatted,toDate:t.toDateFormatted}})},formatDate:function(t){if(!t)return null;console.log("formatDate",t);var e=t.split("-"),a=o()(e,3),n=a[0],r=a[1];return a[2]+"/"+r+"/"+n},parseDate:function(t){if(!t)return null;console.log("parseDate",t);var e=t.split("/"),a=o()(e,3),n=a[0],r=a[1];return a[2]+"-"+r.padStart(2,"0")+"-"+n.padStart(2,"0")}}}},459:function(t,e,a){t.exports={default:a(462),__esModule:!0}},460:function(t,e,a){t.exports={default:a(463),__esModule:!0}},461:function(t,e,a){"use strict";function n(t){return t&&t.__esModule?t:{default:t}}e.__esModule=!0;var o=a(460),r=n(o),i=a(459),s=n(i);e.default=function(){function t(t,e){var a=[],n=!0,o=!1,r=void 0;try{for(var i,u=(0,s.default)(t);!(n=(i=u.next()).done)&&(a.push(i.value),!e||a.length!==e);n=!0);}catch(t){o=!0,r=t}finally{try{!n&&u.return&&u.return()}finally{if(o)throw r}}return a}return function(e,a){if(Array.isArray(e))return e;if((0,r.default)(Object(e)))return t(e,a);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}()},462:function(t,e,a){a(183),a(182),t.exports=a(464)},463:function(t,e,a){a(183),a(182),t.exports=a(465)},464:function(t,e,a){var n=a(35),o=a(185);t.exports=a(34).getIterator=function(t){var e=o(t);if("function"!=typeof e)throw TypeError(t+" is not iterable!");return n(e.call(t))}},465:function(t,e,a){var n=a(117),o=a(19)("iterator"),r=a(53);t.exports=a(34).isIterable=function(t){var e=Object(t);return void 0!==e[o]||"@@iterator"in e||r.hasOwnProperty(n(e))}},466:function(t,e,a){/*!
 * vue-friendly-iframe v0.9.0 (https://github.com/officert/vue-friendly-iframe)
 * (c) 2018 Tim Officer
 * Released under the MIT License.
 */
!function(e,a){t.exports=a()}("undefined"!=typeof self&&self,function(){return function(t){function e(n){if(a[n])return a[n].exports;var o=a[n]={i:n,l:!1,exports:{}};return t[n].call(o.exports,o,o.exports,e),o.l=!0,o.exports}var a={};return e.m=t,e.c=a,e.d=function(t,a,n){e.o(t,a)||Object.defineProperty(t,a,{configurable:!1,enumerable:!0,get:n})},e.n=function(t){var a=t&&t.__esModule?function(){return t.default}:function(){return t};return e.d(a,"a",a),a},e.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},e.p="",e(e.s=0)}([function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a(1),o=function(t){return t&&t.__esModule?t:{default:t}}(n);e.default=o.default,t.exports=e.default},function(t,e,a){var n=a(2)(a(3),a(9),null,null);t.exports=n.exports},function(t,e){t.exports=function(t,e,a,n){var o,r=t=t||{},i=typeof t.default;"object"!==i&&"function"!==i||(o=t,r=t.default);var s="function"==typeof r?r.options:r;if(e&&(s.render=e.render,s.staticRenderFns=e.staticRenderFns),a&&(s._scopeId=a),n){var u=Object.create(s.computed||null);Object.keys(n).forEach(function(t){var e=n[t];u[t]=function(){return e}}),s.computed=u}return{esModule:o,exports:r,options:s}}},function(t,e,a){"use strict";function n(t){return t&&t.__esModule?t:{default:t}}function o(){return(0,i.default)()}Object.defineProperty(e,"__esModule",{value:!0});var r=a(4),i=n(r),s=a(8),u=n(s);e.default={name:"friendly-iframe",props:{src:{type:String,required:!0},className:{type:String,required:!1}},data:function(){return{iframeEl:null,iframeLoadedMessage:"LOADED_IFRAME_"+o()}},computed:{},watch:{src:function(){this.reinitIframe(this)}},methods:{removeIframe:function(){for(;this.$el.firstChild;)this.$el.removeChild(this.$el.firstChild)},setIframeUrl:function(){var t=this.iframeEl.contentWindow.document;t.open().write("<body onload=\"window.location.href='"+this.src+"'; parent.postMessage('"+this.iframeLoadedMessage+"', '*')\"></body>"),t.close()},reinitIframe:u.default.debounce(function(t){t.removeIframe(),t.initIframe()},200),initIframe:function(){this.iframeEl=document.createElement("iframe"),this.iframeEl.setAttribute("crossorigin","anonymous"),this.iframeEl.setAttribute("scrolling","no"),this.iframeEl.setAttribute("target","_parent"),this.iframeEl.setAttribute("style","visibility: hidden; position: absolute; top: -99999px"),this.className&&this.iframeEl.setAttribute("class",this.className),this.$el.appendChild(this.iframeEl),this.setIframeUrl()},listenForEvents:function(){var t=this,e=window.addEventListener?"addEventListener":"attachEvent";(0,window[e])("attachEvent"===e?"onmessage":"message",function(e){e.data===t.iframeLoadedMessage&&(t.$emit("load"),console.log("LOAD"),t.iframeEl.setAttribute("style","visibility: visible;"))},!1)}},mounted:function(){this.listenForEvents(),this.initIframe()}},t.exports=e.default},function(t,e,a){function n(t,e,a){var n=e&&a||0,o=e||[];t=t||{};var i=void 0!==t.clockseq?t.clockseq:u,f=void 0!==t.msecs?t.msecs:(new Date).getTime(),m=void 0!==t.nsecs?t.nsecs:c+1,d=f-l+(m-c)/1e4;if(d<0&&void 0===t.clockseq&&(i=i+1&16383),(d<0||f>l)&&void 0===t.nsecs&&(m=0),m>=1e4)throw new Error("uuid.v1(): Can't create more than 10M uuids/sec");l=f,c=m,u=i,f+=122192928e5;var h=(1e4*(268435455&f)+m)%4294967296;o[n++]=h>>>24&255,o[n++]=h>>>16&255,o[n++]=h>>>8&255,o[n++]=255&h;var v=f/4294967296*1e4&268435455;o[n++]=v>>>8&255,o[n++]=255&v,o[n++]=v>>>24&15|16,o[n++]=v>>>16&255,o[n++]=i>>>8|128,o[n++]=255&i;for(var p=t.node||s,D=0;D<6;++D)o[n+D]=p[D];return e||r(o)}var o=a(5),r=a(7),i=o(),s=[1|i[0],i[1],i[2],i[3],i[4],i[5]],u=16383&(i[6]<<8|i[7]),l=0,c=0;t.exports=n},function(t,e,a){(function(e){var a,n=e.crypto||e.msCrypto;if(n&&n.getRandomValues){var o=new Uint8Array(16);a=function(){return n.getRandomValues(o),o}}if(!a){var r=new Array(16);a=function(){for(var t,e=0;e<16;e++)0==(3&e)&&(t=4294967296*Math.random()),r[e]=t>>>((3&e)<<3)&255;return r}}t.exports=a}).call(e,a(6))},function(t,e){var a;a=function(){return this}();try{a=a||Function("return this")()||(0,eval)("this")}catch(t){"object"==typeof window&&(a=window)}t.exports=a},function(t,e){function a(t,e){var a=e||0,o=n;return o[t[a++]]+o[t[a++]]+o[t[a++]]+o[t[a++]]+"-"+o[t[a++]]+o[t[a++]]+"-"+o[t[a++]]+o[t[a++]]+"-"+o[t[a++]]+o[t[a++]]+"-"+o[t[a++]]+o[t[a++]]+o[t[a++]]+o[t[a++]]+o[t[a++]]+o[t[a++]]}for(var n=[],o=0;o<256;++o)n[o]=(o+256).toString(16).substr(1);t.exports=a},function(t,e,a){"use strict";function n(t,e,a){var n=void 0;return function(){var o=this,r=arguments,i=function(){n=null,a||t.apply(o,r)},s=a&&!n;clearTimeout(n),n=setTimeout(i,e),s&&t.apply(o,r)}}Object.defineProperty(e,"__esModule",{value:!0}),e.default={debounce:n},t.exports=e.default},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement;return(t._self._c||e)("div",{staticClass:"vue-friendly-iframe"})},staticRenderFns:[]}}])})},468:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"form-chitiet"},[a("div",{staticClass:"row-header"},[t._m(0),t._v(" "),a("div",{staticClass:"layout row wrap header_tools row-blue"},[a("div",{staticClass:"flex xs12 pl-3 text-ellipsis text-bold"},[a("v-layout",{staticClass:"chart__report",attrs:{wrap:""}},[t._e(),t._v(" "),"REPORT_01"===t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm2:""}},[a("v-select",{attrs:{items:t.years,autocomplete:"","item-text":"name","item-value":"value","hide-selected":!0},on:{change:t.changeYear},model:{value:t.year,callback:function(e){t.year=e},expression:"year"}})],1):t._e(),t._v(" "),"REPORT_01"===t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm2:""}},[a("v-select",{attrs:{items:t.months,autocomplete:"","item-text":"name","item-value":"value","hide-selected":!0},on:{change:t.changeMonth},model:{value:t.month,callback:function(e){t.month=e},expression:"month"}})],1):t._e(),t._v(" "),"REPORT_01"!==t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm1:""}},[a("v-subheader",{staticClass:"pl-0 text-header"},[t._v("Từ ngày: ")])],1):t._e(),t._v(" "),"REPORT_01"!==t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm2:""}},[a("v-menu",{ref:"menufromDate",attrs:{"close-on-content-click":!1,lazy:"",transition:"scale-transition","offset-y":"","full-width":"","max-width":"290px","min-width":"290px"},model:{value:t.menufromDate,callback:function(e){t.menufromDate=e},expression:"menufromDate"}},[a("v-text-field",{attrs:{slot:"activator","append-icon":"event"},on:{blur:function(e){t.fromDate=t.parseDate(t.fromDateFormatted)}},slot:"activator",model:{value:t.fromDateFormatted,callback:function(e){t.fromDateFormatted=e},expression:"fromDateFormatted"}}),t._v(" "),a("v-date-picker",{attrs:{"no-title":""},on:{input:t.changeFromDate},model:{value:t.fromDate,callback:function(e){t.fromDate=e},expression:"fromDate"}})],1)],1):t._e(),t._v(" "),"REPORT_01"!==t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm1:""}},[a("v-subheader",{staticClass:"pl-0 text-header"},[t._v("Đến ngày: ")])],1):t._e(),t._v(" "),"REPORT_01"!==t.documentTYPE?a("v-flex",{staticClass:"px-2",attrs:{xs6:"",sm2:""}},[a("v-menu",{ref:"menutoDate",attrs:{"close-on-content-click":!1,lazy:"",transition:"scale-transition","offset-y":"","full-width":"","max-width":"290px","min-width":"290px"},model:{value:t.menutoDate,callback:function(e){t.menutoDate=e},expression:"menutoDate"}},[a("v-text-field",{attrs:{slot:"activator","append-icon":"event"},on:{blur:function(e){t.toDate=t.parseDate(t.toDateFormatted)}},slot:"activator",model:{value:t.toDateFormatted,callback:function(e){t.toDateFormatted=e},expression:"toDateFormatted"}}),t._v(" "),a("v-date-picker",{attrs:{"no-title":""},on:{input:t.changeToDate},model:{value:t.toDate,callback:function(e){t.toDate=e},expression:"toDate"}})],1)],1):t._e()],1)],1)])]),t._v(" "),null!==t.pdfBlob&&void 0!==t.pdfBlob&&""!==t.pdfBlob?a("vue-friendly-iframe",{attrs:{src:t.pdfBlob}}):a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{staticClass:"text-xs-center",attrs:{xs12:"","mt-5":""}},[a("v-progress-circular",{attrs:{size:100,width:1,color:"primary",indeterminate:""}})],1)],1)],1)},staticRenderFns:[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"background-triangle-big"},[a("span",[t._v("BÁO CÁO")])])}]}}});
//# sourceMappingURL=0.363553e03cd0beb98ff2.js.map