<template>
  <main role="main">
    <div class="container" style="padding-top: 7rem">
      <hr>
      <div class="row">
        <div class="pili-login">登录</div>
        <div class="col-sm-6 pili-login-intro"
             style="border-right: solid 1px #e5e5e5; margin-top: 3rem; padding: 0 2rem">
          <h1>Built for</h1>
          <h1>teenager</h1>
          <p>PiliPili是一个兼顾娱乐和学习的视频网站，为青少年的课余时间提供更优质的视频资源！</p>
        </div>
        <div class="col-sm-6" style="padding: 0 5rem; margin-top: 3rem">
          <span style="color: #02a7de; font-size: 0.87rem">密码登录</span>
          <input v-model="user.email" type="email" class="form-control" id="email" placeholder="电子邮箱"
                 style="margin: 1rem 0 1.5rem 0"/>
          <input v-model="user.password" type="password" class="form-control" id="pwd" placeholder="密码"/>
          <div class="form-check">
            <label class="form-check-label" style="margin: 2rem 0 1rem 0">
              <input type="checkbox" class="form-check-input" checked="checked" v-model="remember"/>
              <span style="color: #717171; font-size: 0.9rem">记住我&nbsp;<span style="font-size: 0.8rem; color: #bbbbbb">不是自己的电脑上不要勾选此项</span></span>
              <a href="#" style="font-size: 0.8rem; margin-left: 5rem">忘记密码？</a>
            </label>
          </div>
          <div>
            <button type="button" class="btn form-control" id="loginBtn" v-on:click="login()">登录</button>
            <router-link to='/register'>
              <button type="button" class="btn form-control" id="registerBtn">注册</button>
            </router-link>
          </div>
        </div>
      </div>
      <p class="text-center" style="margin: 3rem;font-size: 0.8rem;
    color: #99a2aa">登录即代表你同意<a href="#">用户协议</a>和<a href="#">隐私政策</a></p>
    </div>
  </main>
</template>

<script>
  export default {
    name: 'login',
    data: function () {
      return {
        remember: true, // 记住密码
        user: {},
      }
    },
    mounted() {
      let _this = this;
    },
    methods: {
      //---------------登录框-----------------
      login () {
        let _this = this;

        // 如果密码是从缓存带出来的，则不需要重新加密
        let md5 = hex_md5(_this.user.password);
        let rememberMember = LocalStorage.get(LOCAL_KEY_REMEMBER_MEMBER) || {};
        if (md5 !== rememberMember.md5) {
          _this.user.password = hex_md5(_this.user.password + KEY);
        }

        _this.$ajax.post('http://localhost:9000/business/web/user/login', _this.user).then((response)=>{
          let resp = response.data;
          if (resp.success) {
            console.log("登录成功：", resp.content);
            let loginMember = resp.content;
            Tool.setLoginMember(resp.content);

            // 判断“记住我”
            if (_this.remember) {
              // 如果勾选记住我，则将用户名密码保存到本地缓存
              // 这里保存密码密文，并保存密文md5，用于检测密码是否被重新输入过
              let md5 = hex_md5(_this.user.password);
              LocalStorage.set(LOCAL_KEY_REMEMBER_MEMBER, {
                email: loginMember.email,
                password: _this.user.password,
                md5: md5
              });
            } else {
              // 没有勾选“记住我”时，要把本地缓存清空，否则下次显示登录框时会自动显示用户名密码
              LocalStorage.set(LOCAL_KEY_REMEMBER_MEMBER, null);
            }

            // 登录成功
            _this.$parent.setLoginMember(loginMember);
            _this.$router.push('/index');
          } else {
            toast.warning(resp.message);
            _this.user.password = "";
          }
        });
      },

    },
  }
</script>

<style>
  .pili-login {
    width: 7rem;
    height: 7rem;
    font-size: 40px;
    text-align: center;
    line-height: 7rem;
    border-radius: 50%;
    background-color: #ffffff;
    position: absolute;
    top: 8rem;
    right: 46%;
    z-index: 10;
  }

  #loginBtn {
    width: 45%;
    background-color: #00a7de;
    border: 1px solid #0381aa;
    color: white;
  }

  #loginBtn:hover {
    background-color: #00bee7;
  }

  #registerBtn {
    width: 45%;
    border: 1px solid #ccc;
    background-color: #ffffff;
    float: right;
  }

  #registerBtn:hover {
    background-color: #f7f7f7;
  }

  .pili-login-intro h1 {
    font-size: 64px !important;
    font-family: Inter, -apple-system, BlinkMacSystemFont, Segoe UI, Helvetica, Arial, sans-serif, Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol;
    font-weight: bolder;
    color: #00a0d8;
  }

  .pili-login-intro p {
    font-size: 20px;
    color: #a4a6a9;
  }
</style>