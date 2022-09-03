<template>
  <div class="in-wrap">
    <!-- 开始-公共头引入 -->
    <header id="header">
      <section class="container">
        <h1 id="logo">
          <a href="#" title="龙颜科技">
            <img src="~/assets/img/logo.png" width="100%" alt="龙颜科技">
          </a>
        </h1>
        <div class="h-r-nsl">
          <ul class="nav">
            <router-link to="/" tag="li" active-class="current" exact>
              <a>首页</a>
            </router-link>
            <router-link to="/course" tag="li" active-class="current">
              <a>课程</a>
            </router-link>
            <router-link to="/article" tag="li" active-class="current">
              <a>文章</a>
            </router-link>
            <router-link to="/ask" tag="li" active-class="current">
              <a>问答</a>
            </router-link>
            <router-link to="/amusement" tag="li" active-class="current">
              <a>娱乐</a>
            </router-link>
          </ul>
          <!-- / nav -->
          <!-- / nav -->
          <ul class="h-r-login">
            <li v-if="!loginInfo.id" id="no-login">
              <a @click="openLoginRegister('login')" title="登录">
                <em class="icon18 login-icon">&nbsp;</em>
                <span class="vam ml5">登录</span>
              </a>
              |
              <a @click="openLoginRegister('register')" title="注册">
                <span class="vam ml5">注册</span>
              </a>
            </li>
            <li v-if="loginInfo.id" id="is-login-one" class="mr10">
              <a id="headerMsgCountId" href="#" title="消息">
                <em class="icon18 news-icon">&nbsp;</em>
              </a>
              <q class="red-point" style="display: none">&nbsp;</q>
            </li>
            <li v-if="loginInfo.id" id="is-login-two" class="h-r-user">
              <a href="/ucenter" title>
                <img
                  :src="loginInfo.avatar"
                  width="30"
                  height="30"
                  class="vam picImg"
                  alt
                  >
                <span id="userName" class="vam disIb">{{ loginInfo.nickname }}</span>
              </a>
              <a href="javascript:void(0);" title="退出" @click="logout()" class="ml5">退出</a>
            </li>
            <!-- /未登录显示第1 li；登录后显示第2，3 li -->
          </ul>
          <aside class="h-r-search">
            <form action="#" method="post">
              <label class="h-r-s-box">
                <input type="text" placeholder="搜索" name="queryCourse.courseName" value>
                <button type="submit" class="s-btn">
                  <em class="icon18">&nbsp;</em>
                </button>
              </label>
            </form>
          </aside>
        </div>
        <aside class="mw-nav-btn">
          <div class="mw-nav-icon"></div>
        </aside>
        <div class="clear"></div>
      </section>
    </header>
    <!-- 结束-公共头引入 -->

    <nuxt/>

    <!-- 开始-公共底引入 -->
    <footer id="footer">
      <section class="container">
        <div class="b-foot">
          <section class="fl col-7">
            <section class="mr20">
              <section class="b-f-link">
                <a href="#" title="关于我们" target="_blank">关于我们</a>|
                <a href="#" title="联系我们" target="_blank">联系我们</a>|
                <a href="#" title="帮助中心" target="_blank">帮助中心</a>|
                <a href="#" title="资源下载" target="_blank">资源下载</a>|
                <span>服务热线：0755-1234567(深圳)</span>
                <span>Email：wenwenxing@dragonwen.cn</span>
              </section>
              <section class="b-f-link mt10">
                <span>©{{websiteConfig.year}} 
                  <a :href="websiteConfig.domainName" title="龙颜科技" target="_self">龙颜科技</a>
                  <a :href="websiteConfig.MIIT" title="工信部链接" target="_blank">备案号：{{websiteConfig.ICP}}</a>
                </span>
              </section>
            </section>
          </section>
          <aside class="fl col-3 tac mt15">
            <el-tooltip placement="top" effect="light">
              <div slot="content">
                <img src="~/assets/img/wechat.png" alt>
              </div>
              <section class="gf-tx">
                <span>
                  <img src="~/assets/img/wechat-icon.png" alt>
                </span>
              </section>
            </el-tooltip>
            <el-tooltip placement="top" effect="light">
              <div slot="content">
                <img src="~/assets/img/ali-pay.png" alt>
                <img src="~/assets/img/wechat-pay.png" alt>
              </div>
              <section class="gf-tx">
                <span>
                  <img src="~/assets/img/dashang-icon.png" alt>
                </span>
              </section>
            </el-tooltip>
            
          </aside>
        </div>
      </section>
    </footer>
    <!-- 结束-公共底引入 -->

    <!-- 开始-登录 && 注册 -->
    <el-dialog
      :title="loginRegisterTitle"
      :visible.sync="loginRegisterDialogVisible"
      :close-on-click-modal="false"
      width="30%"
      center>
      <el-dialog
        style="margin-top: 10vh;"
        width="25%"
        title="安全验证"
        :visible.sync="innerVisible"
        :close-on-click-modal="false"
        v-if="innerVisible"
        append-to-body>
        <SliderCaptcha
          ref="sliderCaptchaRef"
          :l="42"
          :r="10"
          :bigImageWidth="catcha.bigImageWidth"
          :bigImageHeight="catcha.bigImageHeight"
          :yHeight="catcha.yHeight"
          :bigImage="catcha.bigImage"
          :smallImage="catcha.smallImage"
          :slider-text="catcha.text"
          @success="onSuccess"
          @fail="onFail"
          @refresh="onRefresh"
        ></SliderCaptcha>
      </el-dialog>
      <div id="po-login-box" class="po-login-box">
        <div id="po-login" class="po-login">
          <!-- 登录方式切换Tab -->
          <ol id="login-tab" :class="loginTab">
            <li :class="mrActivePwd" @click="mrActive('pwd')">
              账号密码登录
            </li>
            <li :class="mrActiveDx" @click="mrActive('dx')">
              手机验证登录
            </li>
          </ol>
          <div id="login-form" class="login-form">
            <!-- 账号密码登录表单 -->
            <div id="login-form-pwd" :class="loginFormPwd">
              <div class="inputs">
                <input v-model="loginFormPassword.name" 
                  @focus="focusLoginFormPwdName()"
                  autocomplete="off" 
                  type="text" 
                  class="input" 
                  placeholder="请输入手机号码或邮箱"/>
                <span class="input-error-notice">{{loginFormPwdNameError}}</span>
              </div>
              <div class="inputs mb40">
                <el-input v-model="loginFormPassword.password" 
                  @focus="focusLoginFormPwdPassword()"
                  autocomplete="off" 
                  placeholder="请输入密码" 
                  type="password" 
                  show-password/>
                <span class="input-error-notice">{{loginFormPwdPasswordError}}</span>
              </div>
              <div class="btns">
                <button id="submit-pwd" class="po-button primary submit" @click="loginSubmit(1)">登录</button>
                <a class="po-link color-out link-forget lf" @click="initLoginFormForgetPwd()">忘记密码?</a>
                <a class="po-link signup rt" @click="initPhoneRegister()">新用户账号注册</a>
              </div>
            </div>
            <!-- 手机验证码登录表单 -->
            <div id="login-form-dx" :class="loginFormDx">
              <div class="inputs">
                <input v-model="phoneCodeLogin.phone" 
                  @focus="focusLoginFormDxPhone()"
                  autocomplete="off" 
                  type="text" 
                  class="input" 
                  placeholder="请输入手机号"/>
                <span class="input-error-notice">{{loginFormDxPhoneError}}</span>
              </div>
              <div class="inputs mb40">
                <span class="input-btn get-code">
                  <a v-show="loginVerifyCode" class="po-link" @click="getLoginPhoneVerifyCode()">获取验证码</a>
                  <i v-show="!loginVerifyCode" class="verify-code" style="font-style:normal;color:#9aa5b8;">{{loginVerifyCodeCount}}秒后重新获取</i>
                </span>
                <input v-model="phoneCodeLogin.code" 
                  @focus="focusLoginFormDxCode()"
                  autocomplete="off" 
                  type="text" 
                  class="input" 
                  placeholder="请输入验证码"/>
                <span class="input-error-notice">{{loginFormDxCodeError}}</span>
              </div>
              <div class="btns">
                <button id="submit-dx" class="po-button primary submit" @click="loginSubmit(2)">登录</button>
                <a class="po-link color-out link-forget lf" @click="initLoginFormForgetPwd()">忘记密码?</a>
                <a class="po-link signup rt" @click="initPhoneRegister()">新用户账号注册</a>
              </div>
            </div>
            <!-- 手机号码验证码注册表单 -->
            <div id="login-form-pregister" :class="loginFormPregister">
              <div class="inputs">
                <input v-model="phoneRegister.phone" 
                  @focus="focusLoginFormRegisterPhone()"
                  autocomplete="off" 
                  type="text" 
                  class="input" 
                  placeholder="请输入手机号"/>
                <span class="input-error-notice">{{loginFormRegisterPhoneError}}</span>
              </div>
              <div class="inputs">
                <span class="input-btn get-code">
                  <a v-show="registerVerifyCode" class="po-link" @click="getRegisterPhoneVerifyCode()">获取验证码</a>
                  <i v-show="!registerVerifyCode" class="verify-code" style="font-style:normal;color:#9aa5b8;">{{registerVerifyCodeCount}}秒后重新获取</i>
                </span>
                <input v-model="phoneRegister.code" 
                  @focus="focusLoginFormRegisterCode()"
                  autocomplete="off" 
                  type="text" 
                  class="input" 
                  placeholder="请输入验证码"/>
                <span class="input-error-notice">{{loginFormRegisterCodeError}}</span>
              </div>
              <div class="inputs mb40">
                <el-input v-model="phoneRegister.password" 
                  @focus="focusLoginFormRegisterPassword()"
                  autocomplete="off" 
                  placeholder="请输入密码" 
                  type="password" 
                  show-password/>
                <span class="input-error-notice">{{loginFormRegisterPasswordError}}</span>
              </div>
              <div class="btns">
                <button id="submit-pregister" class="po-button primary submit" @click="registerSubmit()">注册</button>
                <div class="btns-register">
                  已有账号？
                  <a class="po-link color-black link-to-login" @click="initLoginFormPwd(true)" style="color:#067BEF;position:static">
                    去登录
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
              </div>
            </div>
            <!-- 微信二维码登录或注册 -->
            <div id="login-form-qrcode" :class="loginFormQrcode">
              <div class="qrcode-notice">
                <span class="code">打开</span>
                <img src="~/assets/img/login/icon-wx-svg.svg">
                <span class="code"> 微信<b style="color:#212930"> 扫一扫 </b>完成登录</span>
              </div>
              <div id="qrcode-wx" class="qrcode-wx">
                <img src="~/assets/img/login/showqrcode.png" alt="">
                <div :class="codeInvalid" style="width:200px;height:200px;line-height:200px;background:rgba(255,255,255,0.95);position:absolute;top:0;left:0">
                  二维码已过期，
                  <span @click="loginForWxCode();" style="color:#067BEF;cursor: pointer">刷新</span>
                </div>
              </div>
              <div class="qrcode-btns">
                <div :class="btnsRegister">已有账号？
                  <a class="po-link color-black link-to-login" @click="initLoginFormPwd(true)" style="color:#067BEF">
                    去登录
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
                <div :class="btnsLogin">没有账号？
                  <a class="po-link color-black link-to-register" @click="initPhoneRegister()" style="color:#067BEF;position:static">
                    去注册
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
              </div>
            </div>
            <!-- 扫码登录后绑定手机号码表单 -->
            <div id="login-form-bind" class="login-form-bind hide">
              <div class="login-title">
                <h3 style="text-align: left;font-size:18px;">绑定手机号</h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:16px;text-align: left">
                  为了您的账号安全和正常使用，请您绑定手机号。
                </div>
              </div>
              <div class="inputs">
                <input type="text" name="phone" autocomplete="off" class="input" placeholder="请输入手机号"/>
                <span class="input-error-notice hide"></span>
              </div>
              <div class="inputs">
                <span class="input-btn get-code">
                  <a class="po-link">获取验证码</a>
                </span>
                <input type="text" name="code" autocomplete="off" oninput="if(value>6)value=value.slice(0,6)" class="input" placeholder="请输入验证码" />
                <span class="input-error-notice hide"></span>
              </div>
              <div class="po-buttons btns" style="text-align: right;">
                <div class="po-button-small gray cancel" style="margin-right:16px">暂不绑定</div>
                <div id="bind_account" class="po-button-small primary submit disabled">确认绑定</div>
              </div>
            </div>
            <!-- 确认绑定手机号码成功 -->
            <div id="login-form-bindsucc" class="login-form-bindsucc hide">
              <div class="login-title">
                <img src="~/assets/img/login/icon-succ.png">
                <h3>绑定成功！</h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:10px">您可以在账号中心更换当前绑定信息</div>
              </div>
            </div>
            <!-- 暂不绑定手机号码提示 -->
            <div id="login-form-bindtip" class="login-form-bindtip hide">
              <div class="login-title">
                <img src="~/assets/img/login/icon-tip.png">
                <h3>温馨提示</h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:10px">
                  后续可以在账号中心进行手机号绑定，账号更安全
                </div>
              </div>
            </div>
            <!-- 重置密码表单 -->
            <div id="login-form-forgetpwd" :class="loginFormForgetPwd">
              <div class="first-step">
                <div class="inputs">
                  <input v-model="forgetpwd.name" 
                    @focus="focusLoginFormForgetName()"
                    autocomplete="off" 
                    type="text" 
                    class="input" 
                    placeholder="请输入手机号码或邮箱"/>
                  <span class="input-error-notice">{{loginFormForgetNameError}}</span>
                </div>
                <div class="inputs">
                  <span class="input-btn get-code">
                    <a v-show="forgetPwdVerifyCode" class="po-link" @click="getForgetPwdPhoneVerifyCode()">获取验证码</a>
                    <i v-show="!forgetPwdVerifyCode" class="verify-code" style="font-style:normal;color:#9aa5b8;">{{forgetPwdVerifyCodeCount}}秒后重新获取</i>
                  </span>
                  <input v-model="forgetpwd.code" 
                    @focus="focusLoginFormForgetCode()"
                    autocomplete="off" 
                    type="text" 
                    class="input" 
                    placeholder="请输入验证码"/>
                  <span class="input-error-notice">{{loginFormForgetCodeError}}</span>
                </div>
                <div class="inputs mb40">
                  <el-input v-model="forgetpwd.password" 
                    @focus="focusLoginFormForgetPassword()"
                    autocomplete="off" 
                    placeholder="请输入8-16位数字和字母组合的密码" 
                    type="password" 
                    show-password/>
                  <span class="input-error-notice">{{loginFormForgetPasswordError}}</span>
                </div>
                <div class="btns">
                  <button id="btn-forgetpwd-first" class="po-button primary submit" @click="confirmReset()">确认重置</button>
                  <a class="po-link link-to-login color-black lf" @click="initLoginFormPwd(true)">登录已有账户</a>
                  <a class="po-link signup rt" @click="initPhoneRegister()">新用户账号注册</a>
                </div>
              </div>
            </div>
            <!-- 其他登录方式 -->
            <div id="other-logins" :class="otherLogins">
              <div class="title">
                <h3>其他方式登录</h3>
              </div>
              <ol class="three-list">
                <li :class="wxScanLogin" @click="initLoginQrcode();">
                  <img src="~/assets/img/login/icon-wx-svg.svg" alt="">
                  <span>微信扫码登录</span>
                </li>
                <li :class="linkToAccount" @click="initLoginFormPwd(true)">
                  <img src="~/assets/img/login/icon-account.svg" alt="">
                  <span>账号密码登录</span>
                </li>
                <li :class="linkToPhoneLogin" @click="initLoginFormDx(true)">
                  <img src="~/assets/img/login/icon-phone.svg" alt="">
                  <span>手机验证登录</span>
                </li>
                <li :class="wxScanRegister" @click="initRegisterQrcode()">
                  <img src="~/assets/img/login/icon-wx-svg.svg" alt="">
                  <span>微信扫码注册</span>
                </li>
                <li :class="linkToPhoneRegister" @click="initPhoneRegister()">
                  <img src="~/assets/img/login/icon-phone.svg" alt="">
                  <span>手机验证注册</span>
                </li>
              </ol>
            </div>
          </div>
        </div>
        <!-- 服务条款 -->
        <div :class="poCopyright">
          登录即表示您已阅读并同意
          <a href="https://www.dragonwen.cn" target="_blank" class="po-link">
            服务条款
          </a>
        </div>
      </div>
    </el-dialog>
    <!-- 结束-登录 && 注册 -->
  </div>
</template>
<script>
import '~/assets/css/login/sliderCaptcha.css'
import '~/assets/css/login/login.css'
import '~/assets/css/reset.css'
import '~/assets/css/theme.css'
import '~/assets/css/global.css'
import '~/assets/css/web.css'
import '~/assets/css/base.css'
import '~/assets/css/activity_tab.css'
import '~/assets/css/bottom_rec.css'
import '~/assets/css/nice_select.css'
import '~/assets/css/order.css'
import '~/assets/css/swiper-3.3.1.min.css'
import "~/assets/css/pages-weixinpay.css"

import cookie from 'js-cookie'
import SliderCaptcha from "~/components/SliderCaptcha.vue"
import loginApi from '@/api/login'
import indexApi from '@/api/index'

export default {
  data() {
    return {
        token:'',
        loginInfo: {
          id: '',
          age: '',
          avatar: '',
          mobile: '',
          nickname: '',
          sex: ''
        },
        // 网站配置信息
        websiteConfig: {
          ICP: '粤ICP备20001307号',
          domainName: 'www.dragonwen.cn',
          year: '2018-2022',
          MIIT: 'https://beian.miit.gov.cn/'
        },
        // 是否显示登录&注册弹窗
        loginRegisterDialogVisible: false,
        // 滑块验证码弹出框
        innerVisible: false,
        // 图片验证码传值
        catcha: {
          yHeight: 0,
          bigImage: '',
          smallImage: '',
          text: '向右滑动完成拼图',
          bigImageWidth: 350,
          bigImageHeight: 218,
          modifyImg: '',
          verifyKey: '',
          emailOrPhone: ''
        },
        // 登录 & 注册弹窗标题
        loginRegisterTitle: '',
        // 登录方式切换Tab
        loginTab: 'login-tab hide',
        // 账号密码登录
        mrActivePwd: 'mr active',
        // 手机验证码登录
        mrActiveDx: '',
        // 账号密码登录表单
        loginFormPwd: 'login-form-pwd hide',
        // 手机验证码登录表单
        loginFormDx: 'login-form-dx hide',
        // 微信二维码登录
        loginFormQrcode: 'login-form-qrcode hide',
        // 去注册
        btnsRegister: 'btns-register hide',
        // 去登录
        btnsLogin: 'btns-login hide',
        // 手机验证码注册表单
        loginFormPregister: 'login-form-pregister hide',
        // 重置密码表单
        loginFormForgetPwd: 'login-form-forgetpwd hide',
        // 其他登录方式
        otherLogins: 'other-logins hide',
        // 服务条款
        poCopyright: 'po-copyright',
        // 微信扫码登录按钮
        wxScanLogin: 'wx hide',
        // 账号密码登录按钮
        linkToAccount: 'link-to-account hide',
        // 手机验证登录按钮
        linkToPhoneLogin: 'link-to-plogin hide',
        // 微信扫码注册按钮
        wxScanRegister: 'wx-to-pregister hide',
        // 手机验证注册按钮
        linkToPhoneRegister: 'link-to-pregister hide',
        // 二维码过期模态框
        codeInvalid: 'code-invalid hide',
        // 二维码失效变量
        count: '',
		    timer: null,
        // 登录验证码失效参数
        loginVerifyCode: true,
        loginVerifyCodeTimer: null,
        loginVerifyCodeCount: '',
        // 重置密码验证码失效参数
        forgetPwdVerifyCode: true,
        forgetPwdVerifyCodeTimer: null,
        forgetPwdVerifyCodeCount: '',
        // 手机注册验证码失效参数
        registerVerifyCode: true,
        registerVerifyCodeTimer: null,
        registerVerifyCodeCount: '',
        // 重置密码表单
        forgetpwd: {
          name: '',
          code: '',
          password: ''
        },
        loginFormForgetNameError: '',
        loginFormForgetCodeError: '',
        loginFormForgetPasswordError: '',
        // 账号密码登录表单
        loginFormPassword: {
          name: '',
          password: ''
        },
        loginFormPwdNameError: '',
        loginFormPwdPasswordError: '',
        // 手机验证码注册表单
        phoneRegister: {
          phone: '',
          code: '',
          password: ''
        },
        loginFormRegisterPhoneError: '',
        loginFormRegisterCodeError: '',
        loginFormRegisterPasswordError: '',
        // 手机验证码登录表单
        phoneCodeLogin: {
          phone: '',
          code: ''
        },
        loginFormDxPhoneError: '',
        loginFormDxCodeError: '',
        // 手机号码正则表达式
        phonePattern: /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
        // Email正则表达式
        emailPattern: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
        // 密码正则表达式
        passwordPattern: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/,
        // 登录或注册方式全局标识
        loginOrRegisterType: '',
        // 短信或邮箱验证码Redis Key
        phoneEmailVerifyKey: ''
    }
  },
  created() {
    // 获取网站配置信息
    this.getWebsiteConfig()
    // 获取路径里面token值
    this.token = this.$route.query.token
    console.log(this.token)
    // 判断路径是否有token值
    if(this.token) {
       this.wxLogin()
    }

    this.showInfo()
  },
  methods: {
    // 获取网站配置信息
    getWebsiteConfig(){
      indexApi.getWebsiteConfigInfo().then(res => {
        if(res.data.code === 200){
          this.websiteConfig.ICP = res.data.ICP
          this.websiteConfig.domainName = res.data.domainName
          this.websiteConfig.year = res.data.year
          this.websiteConfig.MIIT = res.data.MIIT
        }
      })
    },
    // 微信登录显示的方法
    wxLogin() {
      // console.log('************'+this.token)
      // 把token值放到cookie里面
      cookie.set('dragon_token',this.token,{domain: 'localhost'})
      cookie.set('dragon_ucenter','',{domain: 'localhost'})
      // console.log('====='+cookie.get('dragon_ucenter'))
      // 调用接口，根据token值获取用户信息
      loginApi.getLoginUserInfo()
        .then(response => {
          // console.log('################'+response.data.data.userInfo)
           this.loginInfo = response.data.data.userInfo
           cookie.set('dragon_ucenter',this.loginInfo,{domain: 'localhost'})
        })
    },
    // 创建方法，从cookie获取用户信息
    showInfo() {
      // 从cookie获取用户信息
      var userStr = cookie.get('dragon_ucenter')
      // 把字符串转换json对象(js对象)
      if(userStr) {
        this.loginInfo = JSON.parse(userStr)
      }
    },

    // 退出
    logout() {
      // 清空cookie值
      cookie.set('dragon_token','',{domain: 'localhost'})
      cookie.set('dragon_ucenter','',{domain: 'localhost'})
      // 回到首页面
      window.location.href = "/";
    },

    // 导航栏 登录 && 注册 按钮
    openLoginRegister(type) {
      this.loginRegisterDialogVisible = true
      if(type === 'login'){
        this.initLoginQrcode()
      }else{
        this.initRegisterQrcode()
      }
      this.loginForWxCode()
    },
    // 初始化扫码注册
    initRegisterQrcode() {
      this.resetLoginRegisterDialog()
      this.loginRegisterTitle = "免费注册"
      this.loginFormQrcode = 'login-form-qrcode'
      this.btnsRegister = 'btns-register'
      // 其他登录方式
      this.otherLogins = 'other-logins'
      // 手机验证注册按钮
      this.linkToPhoneRegister = 'link-to-pregister'
    },
    // 初始化扫码登录
    initLoginQrcode() {
      this.resetLoginRegisterDialog()
      this.loginRegisterTitle = "微信登录"
      this.loginFormQrcode = 'login-form-qrcode'
      this.btnsLogin = 'btns-login'
      // 其他登录方式
      this.otherLogins = 'other-logins'
      // 账号密码登录按钮
      this.linkToAccount = 'link-to-account'
      // 手机验证登录按钮
      this.linkToPhoneLogin = 'link-to-plogin'
    },
    // 初始化账号密码表单登陆
    initLoginFormPwd(flag) {
      if(flag) {
        this.resetLoginRegisterDialog()
      }
      // 账号密码登录
      this.mrActivePwd = 'mr active'
      // 手机验证码登录
      this.mrActiveDx = ''
      // 手机验证码登录表单
      this.loginFormDx = 'login-form-dx hide'

      this.loginRegisterTitle = "欢迎使用"
      this.loginTab = 'login-tab'
      // 账号密码登录表单
      this.loginFormPwd = 'login-form-pwd'
      // 其他登录方式
      this.otherLogins = 'other-logins'
      // 微信扫码登录按钮
      this.wxScanLogin = 'wx'
    },
    // 初始化手机验证码表单登陆
    initLoginFormDx(flag) {
      if(flag) {
        this.resetLoginRegisterDialog()
      }
      // 账号密码登录
      this.mrActivePwd = 'mr'
      // 手机验证码登录
      this.mrActiveDx = 'active'
      // 账号密码登录表单
      this.loginFormPwd = 'login-form-pwd hide'

      this.loginRegisterTitle = "欢迎使用"
      this.loginTab = 'login-tab'
      // 手机验证码登录表单
      this.loginFormDx = 'login-form-dx'
      // 其他登录方式
      this.otherLogins = 'other-logins'
      // 微信扫码登录按钮
      this.wxScanLogin = 'wx'
    },
    // 初始化手机号验证码注册
    initPhoneRegister() {
      this.resetLoginRegisterDialog()
      this.loginRegisterTitle = "免费注册"
      // 手机验证码注册表单
      this.loginFormPregister = 'login-form-pregister'
      // 其他登录方式
      this.otherLogins = 'other-logins'
      // 微信扫码注册按钮
      this.wxScanRegister = 'wx-to-pregister'
    },
    // 初始化重置密码表单
    initLoginFormForgetPwd(){
      this.resetLoginRegisterDialog()
      this.loginRegisterTitle = "重置密码"
      // 重置密码表单
      this.loginFormForgetPwd = 'login-form-forgetpwd'
      // 服务条款
      this.poCopyright = 'po-copyright hide'
    },
    // 登录方式切换Tab点击
    mrActive(type) {
      if(type === 'pwd'){
        this.initLoginFormPwd(false)
      } else if(type === 'dx') {
        this.initLoginFormDx(false)
      }
    },
    // 登录弹窗还原
    resetLoginRegisterDialog(){
      // 登录&注册标题
      this.loginRegisterTitle = ''
      // 登录方式切换Tab
      this.loginTab = 'login-tab hide'
      // 账号密码登录
      this.mrActivePwd = 'mr active',
      // 手机验证码登录
      this.mrActiveDx = '',
      // 账号密码登录表单
      this.loginFormPwd = 'login-form-pwd hide'
      // 手机验证码登录表单
      this.loginFormDx = 'login-form-dx hide'
      // 微信二维码登录
      this.loginFormQrcode = 'login-form-qrcode hide'
      // 去注册
      this.btnsRegister = 'btns-register hide'
      // 去登录
      this.btnsLogin = 'btns-login hide'
      // 手机验证码注册
      this.loginFormPregister = 'login-form-pregister hide'
      // 重置密码表单
      this.loginFormForgetPwd = 'login-form-forgetpwd hide'
      // 其他登录方式
      this.otherLogins = 'other-logins hide'
      // 服务条款
      this.poCopyright = 'po-copyright'
      // 微信扫码登录按钮
      this.wxScanLogin = 'wx hide',
      // 账号密码登录按钮
      this.linkToAccount = 'link-to-account hide',
      // 手机验证登录按钮
      this.linkToPhoneLogin = 'link-to-plogin hide',
      // 微信扫码注册按钮
      this.wxScanRegister = 'wx-to-pregister hide',
      // 手机验证注册按钮
      this.linkToPhoneRegister = 'link-to-pregister hide',
      // 二维码过期模态框
      this.codeInvalid = 'code-invalid hide',
      // 重置密码表单
      this.forgetpwd = {
        name: '',
        code: '',
        password: ''
      },
      this.loginFormForgetNameError = '',
      this.loginFormForgetCodeError = '',
      this.loginFormForgetPasswordError = '',
      // 账号密码登录表单
      this.loginFormPassword = {
        name: '',
        password: ''
      },
      this.loginFormPwdNameError = '',
      this.loginFormPwdPasswordError = ''
      // 手机验证码注册表单
      this.phoneRegister = {
        phone: '',
        code: '',
        password: ''
      },
      this.loginFormRegisterPhoneError = '',
      this.loginFormRegisterCodeError = '',
      this.loginFormRegisterPasswordError = '',
      // 手机验证码登录表单
      this.phoneCodeLogin = {
        phone: '',
        code: ''
      },
      this.loginFormDxPhoneError = '',
      this.loginFormDxCodeError = ''
    },
    // 获取微信二维码
    loginForWxCode() {
      this.codeInvalid = 'code-invalid hide'
      const TIME_COUNT = 30
      if (!this.timer) {
        this.count = TIME_COUNT;
        this.show = false;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= TIME_COUNT) {
            this.count--
          } else {
            this.codeInvalid = 'code-invalid'
            clearInterval(this.timer)
            this.timer = null
          }
        }, 1000)
      }
    },
    // 获取登录手机验证码
    getLoginPhoneVerifyCode() {
      if(this.phoneCodeLogin.phone === '') {
        this.loginFormDxPhoneError = '请输入手机号码'
        return false
      }else if(!this.phonePattern.test(this.phoneCodeLogin.phone)){
        this.loginFormDxPhoneError = '请输入正确的手机号码'
        return false
      }
      // 校验账户是否已注册？
      loginApi.verifyAccount({account: this.phoneCodeLogin.phone}).then(res => {
        if (res.data.code === 200 && res.data.data) {
          this.innerVisible = true
          this.loginOrRegisterType = 'LOGIN_PHONE'
          this.getImageVerifyCode(this.phoneCodeLogin.phone, this.loginOrRegisterType)
        }else {
          this.loginFormDxPhoneError = '账号不存在'
        }
      })
    },
    // 手机号码登录倒计时
    loginPhoneVerifyCodeCountDown(){
      const TIME_COUNT = 120
      if (!this.loginVerifyCodeTimer) {
        this.loginVerifyCodeCount = TIME_COUNT;
        this.loginVerifyCode = false;
        this.loginVerifyCodeTimer = setInterval(() => {
          if (this.loginVerifyCodeCount > 0 && this.loginVerifyCodeCount <= TIME_COUNT) {
            this.loginVerifyCodeCount--
          } else {
            this.loginVerifyCode = true;
            clearInterval(this.loginVerifyCodeTimer)
            this.loginVerifyCodeTimer = null
          }
        }, 1000)
      }
    },
    // 重置密码获取手机验证码
    getForgetPwdPhoneVerifyCode() {
      if(this.forgetpwd.name === '') {
        this.loginFormForgetNameError = '请输入手机号码或邮箱'
        return false
      }else if(!this.phonePattern.test(this.forgetpwd.name) && !this.emailPattern.test(this.forgetpwd.name)){
          this.loginFormForgetNameError = '请输入正确的手机号码或邮箱'
          return false
      }
      // 校验账户是否已注册？
      loginApi.verifyAccount({account: this.forgetpwd.name}).then(res => {
        if (res.data.code === 200 && res.data.data) {
          this.innerVisible = true
          this.loginOrRegisterType = 'FORGET_PWD'
          this.getImageVerifyCode(this.forgetpwd.name, this.loginOrRegisterType)
        }else {
          this.loginFormForgetNameError = '账号不存在'
        }
      })
    },
    // 重置密码倒计时
    forgetPwPhoneVerifyCodeCountDown() {
      const TIME_COUNT = 120
      if (!this.forgetPwdVerifyCodeTimer) {
        this.forgetPwdVerifyCodeCount = TIME_COUNT;
        this.forgetPwdVerifyCode = false;
        this.forgetPwdVerifyCodeTimer = setInterval(() => {
          if (this.forgetPwdVerifyCodeCount > 0 && this.forgetPwdVerifyCodeCount <= TIME_COUNT) {
            this.forgetPwdVerifyCodeCount--
          } else {
            this.forgetPwdVerifyCode = true;
            clearInterval(this.forgetPwdVerifyCodeTimer)
            this.forgetPwdVerifyCodeTimer = null
          }
        }, 1000)
      }
    },
    // 手机注册获取手机验证码
    getRegisterPhoneVerifyCode() {
      if(this.phoneRegister.phone === '') {
        this.loginFormRegisterPhoneError = '请输入手机号码'
        return false
      }else if(!this.phonePattern.test(this.phoneRegister.phone)){
        this.loginFormRegisterPhoneError = '请输入正确的手机号码'
        return false
      }
      // 校验账户是否已注册？
      loginApi.verifyAccount({account: this.phoneRegister.phone}).then(res => {
        if (res.data.code === 200 && !res.data.data) {
          this.innerVisible = true
          this.loginOrRegisterType = 'REGISTER_PHONE'
          this.getImageVerifyCode(this.phoneRegister.phone, this.loginOrRegisterType)
        }else {
          this.loginFormRegisterPhoneError = '账号已存在'
        }
      })
    },
    // 手机号码注册验证码倒计时
    registerPhoneVerifyCodeCountDown(){
      const TIME_COUNT = 120
      if (!this.registerVerifyCodeTimer) {
        this.registerVerifyCodeCount = TIME_COUNT;
        this.registerVerifyCode = false;
        this.registerVerifyCodeTimer = setInterval(() => {
          if (this.registerVerifyCodeCount > 0 && this.registerVerifyCodeCount <= TIME_COUNT) {
            this.registerVerifyCodeCount--
          } else {
            this.registerVerifyCode = true;
            clearInterval(this.registerVerifyCodeTimer)
            this.registerVerifyCodeTimer = null
          }
        }, 1000)
      }
    },
    // 登录按钮点击 type=1 账号密码登录; type=2手机验证码登录
    loginSubmit(type) {
      let returnFlag = false
      if(type === 1) {
        if(this.loginFormPassword.name === '') {
          this.loginFormPwdNameError = '请输入手机号码或邮箱'
          returnFlag = true
        }else if(!this.phonePattern.test(this.loginFormPassword.name) && !this.emailPattern.test(this.loginFormPassword.name)){
          this.loginFormPwdNameError = '请输入正确的手机号码或邮箱'
          returnFlag = true
        }
        if(this.loginFormPassword.password === '') {
          this.loginFormPwdPasswordError = '请输入密码'
          returnFlag = true
        }
      } else if(type == 2) {
        if(this.phoneCodeLogin.phone === '') {
          this.loginFormDxPhoneError = '请输入手机号码'
          returnFlag = true
        }else if(!this.phonePattern.test(this.phoneCodeLogin.phone)){
          this.loginFormDxPhoneError = '请输入正确的手机号码'
          returnFlag = true
        }
        if(this.phoneCodeLogin.code === '') {
          this.loginFormDxCodeError = '请输入验证码'
          returnFlag = true
        }
      }
      if(returnFlag){
        return !returnFlag
      }
    },
    // 确认重置密码按钮点击
    confirmReset() {
      let returnFlag = false
      if(this.forgetpwd.name === '') {
        this.loginFormForgetNameError = '请输入手机号码或邮箱'
        returnFlag = true
      }else if(!this.phonePattern.test(this.forgetpwd.name) && !this.emailPattern.test(this.forgetpwd.name)){
          this.loginFormForgetNameError = '请输入正确的手机号码或邮箱'
          returnFlag = true
      }
      if(this.forgetpwd.code === '') {
        this.loginFormForgetCodeError = '请输入验证码'
        returnFlag = true
      }
      if(!this.passwordPattern.test(this.forgetpwd.password)) {
        this.loginFormForgetPasswordError = '请输入8-16位数字和字母组合的密码'
        returnFlag = true
      }
      if(returnFlag){
        return !returnFlag
      }
    },
    // 手机号码注册按钮点击
    registerSubmit() {
      let returnFlag = false
      if(this.phoneRegister.phone === '') {
        this.loginFormRegisterPhoneError = '请输入手机号码'
        returnFlag = true
      }else if(!this.phonePattern.test(this.phoneRegister.phone)){
        this.loginFormRegisterPhoneError = '请输入正确的手机号码'
        returnFlag = true
      }
      if(this.phoneRegister.code === '') {
        this.loginFormRegisterCodeError = '请输入验证码'
        returnFlag = true
      }
      if(this.phoneRegister.password === '') {
        this.loginFormRegisterPasswordError = '请输入密码'
        returnFlag = true
      }
      if(returnFlag){
        return !returnFlag
      }
    },
    // 账号密码登录input框触发事件
    focusLoginFormPwdName() {
      this.loginFormPwdNameError = ''
    },
    focusLoginFormPwdPassword() {
      this.loginFormPwdPasswordError = ''
    },
    // 手机验证码登录input框触发事件
    focusLoginFormDxPhone () {
      this.loginFormDxPhoneError = ''
    },
    focusLoginFormDxCode() {
      this.loginFormDxCodeError = ''
    },
    // 手机验证码注册input框触发事件
    focusLoginFormRegisterPhone() {
      this.loginFormRegisterPhoneError = ''
    },
    focusLoginFormRegisterCode() {
      this.loginFormRegisterCodeError = ''
    },
    focusLoginFormRegisterPassword() {
      this.loginFormRegisterPasswordError = ''
    },
    // 重置密码input框触发事件
    focusLoginFormForgetName() {
      this.loginFormForgetNameError = ''
    },
    focusLoginFormForgetCode() {
      this.loginFormForgetCodeError = ''
    },
    focusLoginFormForgetPassword() {
      this.loginFormForgetPasswordError = ''
    },
    // 获取图形验证码
    getImageVerifyCode(name) {
      loginApi.getSliderCaptcha({emailOrPhone: name}).then(res => {
        if (res.data.code === 200) {
          let imgObj = res.data
          this.catcha.yHeight = imgObj.yHeight
          this.catcha.bigImage = imgObj.bigImage
          this.catcha.smallImage = imgObj.smallImage
          this.catcha.bigImageWidth = imgObj.bWidth
          this.catcha.bigImageHeight = imgObj.bHeight
          this.catcha.verifyKey = imgObj.verifyKey
          this.catcha.emailOrPhone = imgObj.emailOrPhone
          this.$nextTick(() => {
            if (this.$refs.sliderCaptchaRef) {
              this.$refs.sliderCaptchaRef.reset(imgObj.yHeight)
            }
          })
        }
      })
    },
    onFail() {
      console.log('fail')
    },
    onSuccess(code) {
      let params = {
        code: code, 
        name: this.catcha.emailOrPhone, 
        verifyKey: this.catcha.verifyKey
      }
      // 验证是否成功checkSliderCaptcha是后台验证接口方法 
      loginApi.checkSliderCaptcha(params).then(res => {
        if (res.data.code == 200) {
          this.$refs.sliderCaptchaRef.handleSuccess()
          setTimeout(() => {
            this.innerVisible = false
            this.bigImage = ''
            this.smallImage = ''
            this.phoneEmailVerifyKey = res.data.phoneEmailVerifyKey
            // 倒计时执行
            if(this.loginOrRegisterType === 'LOGIN_PHONE'){
              this.loginPhoneVerifyCodeCountDown()
            } else if(this.loginOrRegisterType === 'FORGET_PWD'){
              this.forgetPwPhoneVerifyCodeCountDown()
            } else if(this.loginOrRegisterType === 'REGISTER_PHONE'){
              this.registerPhoneVerifyCodeCountDown()
            }
          }, 1000)
        } else {
          this.$refs.sliderCaptchaRef.handleFail()
          setTimeout(() => {
            this.getImageVerifyCode(this.catcha.emailOrPhone, this.loginOrRegisterType)
          }, 500)
        }
      }).catch(() => {})
    },
    // 刷新
    onRefresh() {
      this.bigImage = ''
      this.smallImage = ''
      this.getImageVerifyCode(this.catcha.emailOrPhone, this.loginOrRegisterType)
    }
  },
  components: {
    SliderCaptcha
  }
};
</script>
