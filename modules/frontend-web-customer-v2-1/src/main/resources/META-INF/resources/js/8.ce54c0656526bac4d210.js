webpackJsonp([8,9],{217:function(t,e,n){n(666);var o=n(138)(n(662),n(668),"data-v-7cc31a58",null);t.exports=o.exports},219:function(t,e,n){n(683);var o=n(138)(n(671),n(688),null,null);t.exports=o.exports},515:function(t,e,n){var o=n(20),i=n(30),r=n(141),s=n(516),c=n(57).f;t.exports=function(t){var e=i.Symbol||(i.Symbol=r?{}:o.Symbol||{});"_"==t.charAt(0)||t in e||c(e,t,{value:s.f(t)})}},516:function(t,e,n){e.f=n(19)},517:function(t,e,n){var o=n(225),i=n(146).concat("length","prototype");e.f=Object.getOwnPropertyNames||function(t){return o(t,i)}},519:function(t,e,n){"use strict";function o(t){return t&&t.__esModule?t:{default:t}}e.__esModule=!0;var i=n(645),r=o(i),s=n(644),c=o(s),a="function"==typeof c.default&&"symbol"==typeof r.default?function(t){return typeof t}:function(t){return t&&"function"==typeof c.default&&t.constructor===c.default&&t!==c.default.prototype?"symbol":typeof t};e.default="function"==typeof c.default&&"symbol"===a(r.default)?function(t){return void 0===t?"undefined":a(t)}:function(t){return t&&"function"==typeof c.default&&t.constructor===c.default&&t!==c.default.prototype?"symbol":void 0===t?"undefined":a(t)}},644:function(t,e,n){t.exports={default:n(647),__esModule:!0}},645:function(t,e,n){t.exports={default:n(648),__esModule:!0}},647:function(t,e,n){n(656),n(227),n(657),n(658),t.exports=n(30).Symbol},648:function(t,e,n){n(145),n(218),t.exports=n(516).f("iterator")},649:function(t,e,n){var o=n(139),i=n(213),r=n(211);t.exports=function(t){var e=o(t),n=i.f;if(n)for(var s,c=n(t),a=r.f,l=0;c.length>l;)a.call(t,s=c[l++])&&e.push(s);return e}},650:function(t,e,n){var o=n(74);t.exports=Array.isArray||function(t){return"Array"==o(t)}},651:function(t,e,n){var o=n(142)("meta"),i=n(59),r=n(73),s=n(57).f,c=0,a=Object.isExtensible||function(){return!0},l=!n(94)(function(){return a(Object.preventExtensions({}))}),u=function(t){s(t,o,{value:{i:"O"+ ++c,w:{}}})},d=function(t,e){if(!i(t))return"symbol"==typeof t?t:("string"==typeof t?"S":"P")+t;if(!r(t,o)){if(!a(t))return"F";if(!e)return"E";u(t)}return t[o].i},h=function(t,e){if(!r(t,o)){if(!a(t))return!0;if(!e)return!1;u(t)}return t[o].w},f=function(t){return l&&p.NEED&&a(t)&&!r(t,o)&&u(t),t},p=t.exports={KEY:o,NEED:!1,fastKey:d,getWeak:h,onFreeze:f}},652:function(t,e,n){var o=n(211),i=n(96),r=n(95),s=n(214),c=n(73),a=n(224),l=Object.getOwnPropertyDescriptor;e.f=n(58)?l:function(t,e){if(t=r(t),e=s(e,!0),a)try{return l(t,e)}catch(t){}if(c(t,e))return i(!o.f.call(t,e),t[e])}},653:function(t,e,n){var o=n(95),i=n(517).f,r={}.toString,s="object"==typeof window&&window&&Object.getOwnPropertyNames?Object.getOwnPropertyNames(window):[],c=function(t){try{return i(t)}catch(t){return s.slice()}};t.exports.f=function(t){return s&&"[object Window]"==r.call(t)?c(t):i(o(t))}},656:function(t,e,n){"use strict";var o=n(20),i=n(73),r=n(58),s=n(51),c=n(226),a=n(651).KEY,l=n(94),u=n(147),d=n(97),h=n(142),f=n(19),p=n(516),v=n(515),A=n(649),g=n(650),b=n(39),y=n(59),C=n(95),m=n(214),w=n(96),k=n(216),B=n(653),_=n(652),x=n(57),S=n(139),j=_.f,N=x.f,O=B.f,P=o.Symbol,E=o.JSON,D=E&&E.stringify,H=f("_hidden"),T=f("toPrimitive"),U={}.propertyIsEnumerable,I=u("symbol-registry"),M=u("symbols"),z=u("op-symbols"),F=Object.prototype,G="function"==typeof P,R=o.QObject,V=!R||!R.prototype||!R.prototype.findChild,W=r&&l(function(){return 7!=k(N({},"a",{get:function(){return N(this,"a",{value:7}).a}})).a})?function(t,e,n){var o=j(F,e);o&&delete F[e],N(t,e,n),o&&t!==F&&N(F,e,o)}:N,Y=function(t){var e=M[t]=k(P.prototype);return e._k=t,e},q=G&&"symbol"==typeof P.iterator?function(t){return"symbol"==typeof t}:function(t){return t instanceof P},$=function(t,e,n){return t===F&&$(z,e,n),b(t),e=m(e,!0),b(n),i(M,e)?(n.enumerable?(i(t,H)&&t[H][e]&&(t[H][e]=!1),n=k(n,{enumerable:w(0,!1)})):(i(t,H)||N(t,H,w(1,{})),t[H][e]=!0),W(t,e,n)):N(t,e,n)},J=function(t,e){b(t);for(var n,o=A(e=C(e)),i=0,r=o.length;r>i;)$(t,n=o[i++],e[n]);return t},K=function(t,e){return void 0===e?k(t):J(k(t),e)},X=function(t){var e=U.call(this,t=m(t,!0));return!(this===F&&i(M,t)&&!i(z,t))&&(!(e||!i(this,t)||!i(M,t)||i(this,H)&&this[H][t])||e)},L=function(t,e){if(t=C(t),e=m(e,!0),t!==F||!i(M,e)||i(z,e)){var n=j(t,e);return!n||!i(M,e)||i(t,H)&&t[H][e]||(n.enumerable=!0),n}},Q=function(t){for(var e,n=O(C(t)),o=[],r=0;n.length>r;)i(M,e=n[r++])||e==H||e==a||o.push(e);return o},Z=function(t){for(var e,n=t===F,o=O(n?z:C(t)),r=[],s=0;o.length>s;)!i(M,e=o[s++])||n&&!i(F,e)||r.push(M[e]);return r};G||(P=function(){if(this instanceof P)throw TypeError("Symbol is not a constructor!");var t=h(arguments.length>0?arguments[0]:void 0),e=function(n){this===F&&e.call(z,n),i(this,H)&&i(this[H],t)&&(this[H][t]=!1),W(this,t,w(1,n))};return r&&V&&W(F,t,{configurable:!0,set:e}),Y(t)},c(P.prototype,"toString",function(){return this._k}),_.f=L,x.f=$,n(517).f=B.f=Q,n(211).f=X,n(213).f=Z,r&&!n(141)&&c(F,"propertyIsEnumerable",X,!0),p.f=function(t){return Y(f(t))}),s(s.G+s.W+s.F*!G,{Symbol:P});for(var tt="hasInstance,isConcatSpreadable,iterator,match,replace,search,species,split,toPrimitive,toStringTag,unscopables".split(","),et=0;tt.length>et;)f(tt[et++]);for(var nt=S(f.store),ot=0;nt.length>ot;)v(nt[ot++]);s(s.S+s.F*!G,"Symbol",{for:function(t){return i(I,t+="")?I[t]:I[t]=P(t)},keyFor:function(t){if(!q(t))throw TypeError(t+" is not a symbol!");for(var e in I)if(I[e]===t)return e},useSetter:function(){V=!0},useSimple:function(){V=!1}}),s(s.S+s.F*!G,"Object",{create:K,defineProperty:$,defineProperties:J,getOwnPropertyDescriptor:L,getOwnPropertyNames:Q,getOwnPropertySymbols:Z}),E&&s(s.S+s.F*(!G||l(function(){var t=P();return"[null]"!=D([t])||"{}"!=D({a:t})||"{}"!=D(Object(t))})),"JSON",{stringify:function(t){for(var e,n,o=[t],i=1;arguments.length>i;)o.push(arguments[i++]);if(n=e=o[1],(y(e)||void 0!==t)&&!q(t))return g(e)||(e=function(t,e){if("function"==typeof n&&(e=n.call(this,t,e)),!q(e))return e}),o[1]=e,D.apply(E,o)}}),P.prototype[T]||n(52)(P.prototype,T,P.prototype.valueOf),d(P,"Symbol"),d(Math,"Math",!0),d(o.JSON,"JSON",!0)},657:function(t,e,n){n(515)("asyncIterator")},658:function(t,e,n){n(515)("observable")},662:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o=n(519),i=n.n(o),r={colorChecked:"#75C791",colorUnchecked:"#bfcbd9",cssColors:!1,labelChecked:"on",labelUnchecked:"off",width:50,height:22,margin:3},s=function(t,e){return"object"===(void 0===t?"undefined":i()(t))&&t.hasOwnProperty(e)},c=function(t){return t+"px"};e.default={name:"toggle-button",props:{title_checked:"",title_unchecked:"",value:{type:Boolean,default:!1},disabled:{type:Boolean,default:!1},sync:{type:Boolean,default:!1},speed:{type:Number,default:300},color:{type:[String,Object],validator:function(t){return"object"===(void 0===t?"undefined":i()(t))?t.checked||t.unchecked:"string"==typeof t}},cssColors:{type:Boolean,default:!1},labels:{type:[Boolean,Object],default:!1,validator:function(t){return"object"===(void 0===t?"undefined":i()(t))?t.checked||t.unchecked:"boolean"==typeof t}},height:{type:Number,default:r.height},width:{type:Number,default:r.width}},computed:{className:function(){return["vue-js-switch",{toggled:this.toggled,disabled:this.disabled}]},ariaChecked:function(){return this.toggled.toString()},coreStyle:function(){return{width:c(this.width),height:c(this.height),backgroundColor:this.cssColors?null:this.colorCurrent,borderRadius:c(Math.round(this.height/2))}},maxWidth:function(){return{width:c(this.width)+"!important"}},buttonRadius:function(){return this.height-2*r.margin},distance:function(){return c(this.width-this.height+r.margin)},buttonStyle:function(){return{width:c(this.buttonRadius),height:c(this.buttonRadius),transition:"transform "+this.speed+"ms",transform:this.toggled?"translate3d("+this.distance+", 3px, 0px)":null}},labelStyle:function(){return{lineHeight:c(this.height)}},colorChecked:function(){var t=this.color;return"object"!==(void 0===t?"undefined":i()(t))?t||r.colorChecked:s(t,"checked")?t.checked:r.colorChecked},colorUnchecked:function(){var t=this.color;return s(t,"unchecked")?t.unchecked:r.colorUnchecked},colorCurrent:function(){return this.toggled?this.colorChecked:this.colorUnchecked},labelChecked:function(){return s(this.labels,"checked")?this.labels.checked:r.labelChecked},labelUnchecked:function(){return s(this.labels,"unchecked")?this.labels.unchecked:r.labelUnchecked}},watch:{value:function(t){this.sync&&(this.toggled=!!t)}},data:function(){return{toggled:!!this.value}},methods:{toggle:function(t){this.toggled=!this.toggled,this.$emit("input",this.toggled),this.$emit("change",{value:this.toggled,srcEvent:t})}}}},664:function(t,e,n){e=t.exports=n(512)(!0),e.push([t.i,".vue-js-switch[data-v-7cc31a58]{display:inline-block;position:relative;overflow:hidden;vertical-align:middle;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;font-size:10px;cursor:pointer}.vue-js-switch .v-switch-input[data-v-7cc31a58]{display:none}.vue-js-switch .v-switch-label[data-v-7cc31a58]{position:absolute;top:0;font-weight:600;color:#fff}.vue-js-switch .v-switch-label.v-left[data-v-7cc31a58]{left:10px}.vue-js-switch .v-switch-label.v-right[data-v-7cc31a58]{right:10px}.vue-js-switch .v-switch-core[data-v-7cc31a58]{display:block;position:relative;box-sizing:border-box;outline:0;margin:0;transition:border-color .3s,background-color .3s;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none}.vue-js-switch .v-switch-core .v-switch-button[data-v-7cc31a58]{display:block;position:absolute;overflow:hidden;top:0;left:0;transform:translate3d(3px,3px,0);border-radius:100%;background-color:#fff}.vue-js-switch.disabled[data-v-7cc31a58]{pointer-events:none;opacity:1}","",{version:3,sources:["d:/FDS_OPENCPS/front-end-v2.1/frontend-opencps-v2.1/onegate_21_fe/src/components/toggleButton.vue"],names:[],mappings:"AACA,gCACE,qBAAsB,AACtB,kBAAmB,AACnB,gBAAiB,AACjB,sBAAuB,AACvB,yBAA0B,AACvB,sBAAuB,AACtB,qBAAsB,AAClB,iBAAkB,AAC1B,eAAgB,AAChB,cAAe,CAChB,AACD,gDACE,YAAa,CACd,AACD,gDACE,kBAAmB,AACnB,MAAO,AACP,gBAAiB,AACjB,UAAY,CACb,AACD,uDACE,SAAU,CACX,AACD,wDACE,UAAW,CACZ,AACD,+CACE,cAAe,AACf,kBAAmB,AACnB,sBAAuB,AACvB,UAAW,AACX,SAAU,AACV,iDAAqD,AACrD,yBAA0B,AACvB,sBAAuB,AACtB,qBAAsB,AAClB,gBAAiB,CAC1B,AACD,gEACE,cAAe,AACf,kBAAmB,AACnB,gBAAiB,AACjB,MAAO,AACP,OAAQ,AACR,iCAAoC,AACpC,mBAAoB,AACpB,qBAAsB,CACvB,AACD,yCACE,oBAAqB,AACrB,SAAU,CACX",file:"toggleButton.vue",sourcesContent:["\n.vue-js-switch[data-v-7cc31a58] {\r\n  display: inline-block;\r\n  position: relative;\r\n  overflow: hidden;\r\n  vertical-align: middle;\r\n  -webkit-user-select: none;\r\n     -moz-user-select: none;\r\n      -ms-user-select: none;\r\n          user-select: none;\r\n  font-size: 10px;\r\n  cursor: pointer\n}\n.vue-js-switch .v-switch-input[data-v-7cc31a58] {\r\n  display: none\n}\n.vue-js-switch .v-switch-label[data-v-7cc31a58] {\r\n  position: absolute;\r\n  top: 0;\r\n  font-weight: 600;\r\n  color: white\n}\n.vue-js-switch .v-switch-label.v-left[data-v-7cc31a58] {\r\n  left: 10px\n}\n.vue-js-switch .v-switch-label.v-right[data-v-7cc31a58] {\r\n  right: 10px\n}\n.vue-js-switch .v-switch-core[data-v-7cc31a58] {\r\n  display: block;\r\n  position: relative;\r\n  box-sizing: border-box;\r\n  outline: 0;\r\n  margin: 0;\r\n  transition: border-color 0.3s, background-color 0.3s;\r\n  -webkit-user-select: none;\r\n     -moz-user-select: none;\r\n      -ms-user-select: none;\r\n          user-select: none\n}\n.vue-js-switch .v-switch-core .v-switch-button[data-v-7cc31a58] {\r\n  display: block;\r\n  position: absolute;\r\n  overflow: hidden;\r\n  top: 0;\r\n  left: 0;\r\n  transform: translate3d(3px, 3px, 0);\r\n  border-radius: 100%;\r\n  background-color: #fff\n}\n.vue-js-switch.disabled[data-v-7cc31a58] {\r\n  pointer-events: none;\r\n  opacity: 1\n}\r\n"],sourceRoot:""}])},666:function(t,e,n){var o=n(664);"string"==typeof o&&(o=[[t.i,o,""]]),o.locals&&(t.exports=o.locals);n(513)("120c24d1",o,!0)},668:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("label",{class:t.className,style:t.maxWidth,attrs:{role:"checkbox",title:t.toggled?t.title_checked:t.title_unchecked,"aria-checked":t.ariaChecked}},[n("input",{staticClass:"v-switch-input",attrs:{type:"checkbox"},on:{change:function(e){return e.stopPropagation(),t.toggle(e)}}}),t._v(" "),n("div",{staticClass:"v-switch-core",style:t.coreStyle},[n("div",{staticClass:"v-switch-button",style:t.buttonStyle})]),t._v(" "),t.labels?[t.toggled?n("span",{staticClass:"v-switch-label v-left",style:t.labelStyle,domProps:{innerHTML:t._s(t.labelChecked)}}):n("span",{staticClass:"v-switch-label v-right",style:t.labelStyle,domProps:{innerHTML:t._s(t.labelUnchecked)}})]:t._e()],2)},staticRenderFns:[]}},671:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o=n(37),i=n.n(o),r=n(217),s=n.n(r);e.default={components:{"toggle-button":s.a},props:{assign_items:{type:Array,default:function(){return[]}},type:{type:Number,default:function(){return 1}},configNote:{type:Object,default:function(){}}},model:{prop:"assign_items"},data:function(){return{data_phancong:[],assignedtype_items:{2:[{text:"Không có phân công",value:0},{text:"Thực hiện chính",value:1},{text:"Thực hiện phối hợp",value:2}],3:[{text:"Không có phân công",value:0},{text:"Thực hiện chính",value:1},{text:"Thực hiện phối hợp",value:2},{text:"Theo dõi",value:3}]},title_asign:{1:"PHÂN CÔNG NGƯỜI THỰC HIỆN",2:"PHÂN CÔNG THỰC HIỆN, PHỐI HỢP",3:"PHÂN CÔNG THỰC HIỆN, PHỐI HỢP VÀ THEO DÕI"},presenterAddGroup:!0,assignValidate:!0}},created:function(){setTimeout(function(){i()(".btn-tgl").addClass("btn-hidden")},200)},mounted:function(){this.data_phancong=this.assign_items},methods:{changeAssigned:function(t,e){var n=this;1===n.type&&(n.assign_items[e].assigned=!0===t?1:0)},checkAsign:function(t,e){var n=this;t?(n.assign_items[e].assigned=1,i()("#btn-"+e).removeClass("btn-hidden")):(n.assign_items[e].assigned=0,i()("#btn-"+e).addClass("btn-hidden"))},changeTypeAssign:function(t,e){var n=this;t.value?(n.assign_items[e].assigned=1,i()("#btn-"+e).removeClass("btn-hidden")):(n.assign_items[e].assigned=2,i()("#btn-"+e).addClass("btn-hidden"))},doExport:function(){var t=this;return 0===t.assign_items.filter(function(t){return Number(t.assigned)>0}).length?(t.assignValidate=!1,t.assignValidate):(t.assignValidate=!0,t.assignValidate)}}}},681:function(t,e,n){e=t.exports=n(512)(!0),e.push([t.i,".btn-hidden{display:none!important}","",{version:3,sources:["d:/FDS_OPENCPS/front-end-v2.1/frontend-opencps-v2.1/onegate_21_fe/src/components/form_xu_ly/PhanCongNguoiThucHien.vue"],names:[],mappings:"AACA,YACE,sBAAwB,CACzB",file:"PhanCongNguoiThucHien.vue",sourcesContent:["\n.btn-hidden {\n  display: none !important\n}\n"],sourceRoot:""}])},683:function(t,e,n){var o=n(681);"string"==typeof o&&(o=[[t.i,o,""]]),o.locals&&(t.exports=o.locals);n(513)("57de0106",o,!0)},688:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"phancong",staticStyle:{"background-color":"white",width:"100%"}},[n("v-expansion-panel",{staticClass:"expansion-pl"},[n("v-expansion-panel-content",{attrs:{"hide-actions":"",value:"1"}},[n("div",{attrs:{slot:"header"},slot:"header"},[n("div",{staticClass:"background-triangle-small"},[n("v-icon",{attrs:{size:"18",color:"white"}},[t._v("star_rate")])],1),t._v("Chọn người thực hiện\n      ")]),t._v(" "),n("v-card",[1===t.type?n("v-card-text",{staticClass:"py-1"},[n("v-layout",{attrs:{wrap:""}},t._l(t.data_phancong,function(e,o){return n("v-checkbox",{key:e.userId,staticStyle:{display:"inline-block"},attrs:{label:e.userName},on:{change:function(e){t.changeAssigned(e,o)}},model:{value:e.assigned,callback:function(n){t.$set(e,"assigned",n)},expression:"item.assigned"}})})),t._v(" "),t.assignValidate?t._e():n("span",{staticClass:"ml-3",staticStyle:{color:"#f44336"}},[t._v("* Yêu cầu chọn người để thực hiện")])],1):n("v-card-text",{staticClass:"px-2 py-1"},[n("v-layout",{staticClass:"my-1",attrs:{wrap:""}},t._l(t.data_phancong,function(e,o){return n("div",{key:e.userId,staticClass:"ml-3"},[n("v-layout",{attrs:{wrap:""}},[n("v-tooltip",{attrs:{top:""}},[n("v-checkbox",{staticStyle:{"min-width":"150px"},attrs:{slot:"activator",label:e.userName},on:{change:function(e){t.checkAsign(e,o)}},slot:"activator",model:{value:e.assigned,callback:function(n){t.$set(e,"assigned",n)},expression:"item.assigned"}}),t._v(" "),n("span",{staticClass:"pl-0"},[t._v(" "+t._s(e.userName)+" ")])],1),t._v(" "),n("toggle-button",{staticClass:"mx-1 btn-tgl",attrs:{id:"btn-"+o,title_checked:"Thực hiện",title_unchecked:"Phối hợp",labels:{checked:"TH",unchecked:"PH"},color:{checked:"#7DCE94",unchecked:"#82C7EB"},width:50},on:{change:function(e){t.changeTypeAssign(e,o)}},model:{value:t.presenterAddGroup,callback:function(e){t.presenterAddGroup=e},expression:"presenterAddGroup"}})],1)],1)})),t._v(" "),t.assignValidate?t._e():n("span",{staticClass:"ml-3",staticStyle:{color:"#f44336"}},[t._v("* Yêu cầu chọn người để thực hiện")])],1)],1)],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=8.ce54c0656526bac4d210.js.map