<template>
  <main role="main" style="margin-bottom: 10rem">
    <div class="container" style="padding-top: 7rem;">
      <hr>
      <div class="pili-register">注册</div>
      <div class="pili-register-box">
        <input type="text" class="form-control" id="username" placeholder="昵称"/>
        <input type="password" class="form-control" id="pwd" placeholder="密码"/>
        <input type="password" class="form-control" id="pwdConfirm" placeholder="确认密码"/>
        <input type="email" class="form-control" id="email" placeholder="电子邮箱"/>
        <div class="form-check" style="margin: 0.5rem 0">
          <label class="form-check-label">
            <input type="checkbox" class="form-check-input" checked="checked" style="margin-top: 0.5rem"/>
            <span style="color: #717171; font-size: 0.85rem;">我已同意<a href="#">《噼哩噼哩弹幕网用户使用协议》</a>和<a
              href="#">《噼哩噼哩隐私政策》</a></span>
          </label>
        </div>
        <button type="button" class="btn form-control" id="registerBtn2">注册</button>
        <a href="/login" style="float: right; font-size: 0.85rem; margin-top: 0.5rem;">已有账号，直接登录></a>
      </div>
    </div>
  </main>
</template>

<script>
  export default {
    name: 'register',
    data: function () {
      return {

      }
    },
    mounted() {
      let _this = this;
    },
    methods: {},
  }
</script>

<style>
  .pili-register-box input {
    margin-top: 2rem;
  }

  .pili-register-box {
    margin: 3rem auto;
    width: 100%;
    max-width: 27rem;
    padding-top: 1rem;
  }

  .pili-register {
    width: 7rem;
    height: 7rem;
    font-size: 40px;
    text-align: center;
    line-height: 7rem;
    border-radius: 50%;
    background-color: #ffffff;
    position: absolute;
    top: 8rem;
    right: 47%;
  }

  #registerBtn2 {
    background-color: #00a7de;
    border: 1px solid #0381aa;
    color: white;
    width: 100%;
  }

  #registerBtn2:hover {
    background-color: #00bee7;
  }
</style>