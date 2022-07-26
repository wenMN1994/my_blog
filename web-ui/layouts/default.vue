<template>
  <div class="in-wrap">
    <!-- 公共头引入 -->
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
    <!-- /公共头引入 -->

    <nuxt/>

    <!-- 公共底引入 -->
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
                <span>©2018-2022 龙颜科技
                  <a href="https://beian.miit.gov.cn/" title="工信部链接" target="_blank">备案号：粤ICP备20001307号</a>
                </span>
              </section>
            </section>
          </section>
          <aside class="fl col-3 tac mt15">
            <section class="gf-tx">
              <span>
                <img src="~/assets/img/wx-icon.png" alt>
              </span>
            </section>
            <section class="gf-tx">
              <span>
                <img src="~/assets/img/wb-icon.png" alt>
              </span>
            </section>
          </aside>
        </div>
      </section>
    </footer>
    <!-- /公共底引入 -->
    <!-- 登录 && 注册 -->
    <el-dialog
      :title="loginRegisterTitle"
      :visible.sync="loginRegisterDialogVisible"
      width="30%"
      center>
      <div id="po-login-box" class="po-login-box">
        <div id="po-login" class="po-login">
          <ol id="login-tab" class="login-tab hide">
            <li class="mr active" _data="pwd">
              账号密码登录
            </li>
            <li _data="dx">
              手机验证登录
            </li>
          </ol>
          <div id="login-form" class="login-form">
            <div id="login-form-pwd" class="login-form-pwd hide">
              <div class="inputs">
                <input type="text" name="name" autocomplete="off" class="input" placeholder="请输入手机号码或邮箱"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="inputs mb40">
                <span class="input-btn show-pwd show-pwd__open">
                </span>
                <input type="password" name="pwd" autoComplete="new-password" class="input"
                placeholder="输入密码" />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="btns">
                <button id="submit-pwd" class="po-button primary submit disabled">
                  登录
                </button>
                <a class="po-link color-out link-forget lf">
                  忘记密码?
                </a>
                <a class="po-link signup rt">
                  新用户账号注册
                </a>
              </div>
            </div>
            <div id="login-form-dx" class="login-form-dx hide">
              <div class="inputs">
                <input type="text" autocomplete="off" name="phone" class="input" placeholder="请输入手机号"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="inputs mb40">
                <span class="input-btn get-code">
                  <a class="po-link">
                    获取验证码
                  </a>
                </span>
                <input type="text" autocomplete="off" name="code" class="input" placeholder="请输入验证码"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="btns">
                <button id="submit-dx" class="po-button primary submit disabled">
                  登录
                </button>
                <a class="po-link color-out link-forget lf">
                  忘记密码?
                </a>
                <a class="po-link signup rt">
                  新用户账号注册
                </a>
              </div>
            </div>
            <div id="login-form-pregister" class="login-form-pregister hide">
              <div class="inputs">
                <input type="text" autocomplete="off" name="phone" class="input" placeholder="请输入手机号"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <input name="tampkey" id="tampkey" type="hidden" />
              <div class="inputs">
                <span class="input-btn get-code">
                  <a class="po-link">
                    获取验证码
                  </a>
                </span>
                <input type="text" autocomplete="off" name="code" class="input" placeholder="请输入验证码"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="inputs mb40">
                <span class="input-btn show-pwd show-pwd__open">
                </span>
                <input type="password" autocomplete="off" name="pwd" class="input" placeholder="请输入密码"/>
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="btns">
                <button id="submit-pregister" class="po-button primary submit disabled">
                  注册
                </button>
                <div class="btns-register">
                  已有账号？
                  <a class="po-link color-black link-to-login" style="color:#067BEF;position:static">
                    去登录
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
              </div>
            </div>
            <div id="login-form-qrcode" :class="loginFormQrcode">
              <div class="qrcode-notice">
                <span class="code">
                  打开
                </span>
                <img src="~/assets/img/login/icon-wx-svg.svg">
                <span class="code">
                  微信
                  <b style="color:#212930">
                    扫一扫
                  </b>
                  完成登录
                </span>
              </div>
              <div id="qrcode-wx" class="qrcode-wx">
                <img src="~/assets/img/login/showqrcode.png" alt="">
              </div>
              <div class="qrcode-btns">
                <div :class="btnsRegister">
                  已有账号？
                  <a class="po-link color-black link-to-login" style="color:#067BEF">
                    去登录
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
                <div :class="btnsLogin">
                  没有账号？
                  <a class="po-link color-black link-to-register" style="color:#067BEF;position:static">
                    去注册
                    <img src="~/assets/img/login/icons-arrow-r.svg" style="vertical-align: middle;margin-top:-2px">
                  </a>
                </div>
              </div>
            </div>
            <div id="login-form-register" class="login-form-register hide">
              <div class="inputs">
                <input type="text" name="phone" autocomplete="off" class="input" placeholder="请输入手机号"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <input name="tampkey" id="tampkey" type="hidden" />
              <div class="inputs">
                <span class="input-btn get-code">
                  <a class="po-link">
                    获取验证码
                  </a>
                </span>
                <input type="text" name="code" autocomplete="off" class="input" placeholder="请输入验证码"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="inputs  mb40">
                <span class="input-btn show-pwd show-pwd__open">
                </span>
                <input type="password" name="pwd" autocomplete="off" class="input" placeholder="请输入密码"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="btns">
                <button class="po-button primary submit disabled">
                  注册
                </button>
                <a class="po-link center link-to-login">
                  登录已有账号
                </a>
              </div>
            </div>
            <div id="login-form-bind" class="login-form-bind hide">
              <div class="login-title">
                <h3 style="text-align: left;font-size:18px;">
                  绑定手机号
                </h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:16px;text-align: left">
                  为了您的账号安全和正常使用，请您绑定手机号。
                </div>
              </div>
              <div class="inputs">
                <input type="text" name="phone" autocomplete="off" class="input" placeholder="请输入手机号"
                />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="inputs">
                <span class="input-btn get-code">
                  <a class="po-link">
                    获取验证码
                  </a>
                </span>
                <input type="text" name="code" autocomplete="off" oninput="if(value>6)value=value.slice(0,6)"
                class="input" placeholder="请输入验证码" />
                <span class="input-error-notice hide">
                </span>
              </div>
              <div class="po-buttons btns" style="text-align: right;">
                <div class="po-button-small gray cancel" style="margin-right:16px">
                  暂不绑定
                </div>
                <div id="bind_account" class="po-button-small primary submit disabled">
                  确认绑定
                </div>
              </div>
            </div>
            <div id="login-form-bindsucc" class="login-form-bindsucc hide">
              <div class="login-title">
                <img src="~/assets/img/login/icon-succ.png">
                <h3>
                  绑定成功！
                </h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:10px">
                  您可以在账号中心更换当前绑定信息
                </div>
              </div>
            </div>
            <div id="login-form-bindtip" class="login-form-bindtip hide">
              <div class="login-title">
                <img src="~/assets/img/login/icon-tip.png">
                <h3>
                  温馨提示
                </h3>
                <div style="font-size:14px;color:#6C7D8F;margin-top:10px">
                  后续可以在账号中心进行手机号绑定，账号更安全
                </div>
              </div>
            </div>
            <div id="login-form-forgetpwd" class="login-form-forgetpwd hide">
              <div class="first-step">
                <div class="inputs">
                  <input type="text" autocomplete="off" name="name" class="input" placeholder="请输入手机号码或邮箱"
                  />
                  <span class="input-error-notice hide">
                  </span>
                </div>
                <div class="inputs">
                  <span class="input-btn get-code">
                    <a class="po-link">
                      获取验证码
                    </a>
                  </span>
                  <input type="text" name="code" autocomplete="off" class="input" placeholder="请输入验证码"
                  />
                  <span class="input-error-notice hide">
                  </span>
                </div>
                <div class="inputs mb40">
                  <span class="input-btn show-pwd show-pwd__open">
                  </span>
                  <input type="password" name="pwd" autocomplete="off" class="input" placeholder="请输入8-16位数字和字母组合的密码"
                  />
                  <span class="input-error-notice hide">
                  </span>
                </div>
                <div class="btns">
                  <button id="btn-forgetpwd-first" class="po-button primary submit disabled">
                    确认重置
                  </button>
                  <a class="po-link link-to-login color-black lf">
                    登录已有账户
                  </a>
                  <a class="po-link signup rt">
                    新用户账号注册
                  </a>
                </div>
              </div>
            </div>
            <div id="other-logins" :class="otherLogins">
              <div class="title">
                <h3>
                  其他方式登录
                </h3>
              </div>
              <ol class="three-list">
                <li class="wx" onclick="loginModel.platform.loginForWeixin()">
                  <img src="~/assets/img/login/icon-wx-svg.svg" alt="">
                  <span>
                    微信扫码登录
                  </span>
                </li>
                <li class="link-to-account">
                  <img src="~/assets/img/login/icon-account.svg" alt="">
                  <span>
                    账号密码登录
                  </span>
                </li>
                <li class="link-to-plogin">
                  <img src="~/assets/img/login/icon-phone.svg" alt="">
                  <span>
                    手机验证登录
                  </span>
                </li>
                <li class="wx-to-pregister">
                  <img src="~/assets/img/login/icon-wx-svg.svg" alt="">
                  <span>
                    微信扫码注册
                  </span>
                </li>
                <li class="link-to-pregister">
                  <img src="~/assets/img/login/icon-phone.svg" alt="">
                  <span>
                    手机验证注册
                  </span>
                </li>
                <li class="dropdown po-tool-button three-login" id="three-login" style="margin-right:0">
                  <img src="~/assets/img/login/icon-qq-svg.svg" alt="">
                  <span class="text">
                    QQ登录
                  </span>
                </li>
                <li onclick="loginModel.platform.login('qq')" class="three-register" style="margin-right:0">
                  <img src="~/assets/img/login/icon-qq-svg.svg" alt="">
                  <span class="text">
                    QQ注册
                  </span>
                </li>
              </ol>
            </div>
          </div>
        </div>
        <div class="po-copyright">
          登录即表示您已阅读并同意
          <a href="https://www.processon.com/tos" target="_blank" class="po-link">
            服务条款
          </a>
        </div>
      </div>
      <div class="menu-container">
        <ul id="three-login-list" class="po-menu" style="display: none">
          <li class="po-menu-item" ac="qq">
            <div class="po-menu-item-box">
              <img src="~/assets/img/login/icon-qq-svg.svg" alt="">
              <span class="text">
                QQ登录
              </span>
            </div>
          </li>
          <li class="po-menu-item" ac="sina">
            <div class="po-menu-item-box">
              <img src="~/assets/img/login/icon-wb-svg.svg" alt="">
              <span class="text">
                微博登录
              </span>
            </div>
          </li>
          <li class="po-menu-item" ac="google">
            <div class="po-menu-item-box">
              <img src="~/assets/img/login/icon-gg-svg.svg" alt="">
              <span class="text">
                谷歌登录
              </span>
            </div>
          </li>
        </ul>
      </div>
    </el-dialog>
    <!-- /登录 && 注册 -->
  </div>
</template>
<script>
import '~/assets/css/login.css'
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
import loginApi from '@/api/login'

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
        loginRegisterDialogVisible: false,
        loginRegisterTitle: '',
        // 微信二维码登录
        loginFormQrcode: 'login-form-qrcode hide',
        btnsRegister: 'btns-register hide',
        btnsLogin: 'btns-login hide',
        otherLogins: 'other-logins hide'
    }
  },
  created() {
    // 获取路径里面token值
    this.token = this.$route.query.token
    console.log(this.token)
    // 判断路径是否有token值
    if(this.token) {
       this.wxLogin()
    }

    this.showInfo()
  },
  methods:{
    // 微信登录显示的方法
    wxLogin() {
      // console.log('************'+this.token)
      // 把token值放到cookie里面
      cookie.set('guli_token',this.token,{domain: 'localhost'})
      cookie.set('guli_ucenter','',{domain: 'localhost'})
      // console.log('====='+cookie.get('guli_token'))
      // 调用接口，根据token值获取用户信息
      loginApi.getLoginUserInfo()
        .then(response => {
          // console.log('################'+response.data.data.userInfo)
           this.loginInfo = response.data.data.userInfo
           cookie.set('guli_ucenter',this.loginInfo,{domain: 'localhost'})
        })
    },
    // 创建方法，从cookie获取用户信息
    showInfo() {
      // 从cookie获取用户信息
      var userStr = cookie.get('guli_ucenter')
      // 把字符串转换json对象(js对象)
      if(userStr) {
        this.loginInfo = JSON.parse(userStr)
      }
    },

    // 退出
    logout() {
      // 清空cookie值
      cookie.set('guli_token','',{domain: 'localhost'})
      cookie.set('guli_ucenter','',{domain: 'localhost'})
      // 回到首页面
      window.location.href = "/";
    },

    // 登录 && 注册
    openLoginRegister(type) {
      this.loginRegisterDialogVisible = true
      this.resetLoginRegisterDialog()
      if(type === 'login'){
        this.loginRegisterTitle = "微信登录"
        this.loginFormQrcode = 'login-form-qrcode'
        this.btnsRegister = 'btns-register'
        this.otherLogins = 'other-logins'
      }else{
        this.loginRegisterTitle = "免费注册"
        this.loginFormQrcode = 'login-form-qrcode'
        this.btnsLogin = 'btns-login'
        this.otherLogins = 'other-logins'
      }
    },
    // 登录弹窗还原
    resetLoginRegisterDialog(){
      this.loginRegisterTitle = '',
      // 微信二维码登录
      this.loginFormQrcode = 'login-form-qrcode hide',
      this.btnsRegister = 'btns-register hide',
      this.btnsLogin = 'btns-login hide',
      this.otherLogins = 'other-logins hide'
    }
  }
};
</script>
