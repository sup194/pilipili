<template>
  <main role="main" style="margin-bottom: 10rem">
    <div class="container" style="padding-top: 7rem;">
      <hr>
      <div class="pili-register">注册</div>
      <div class="pili-register-box">
        <input v-on:blur="onRegisterNameBlur()"
               v-bind:class="registerNameValidateClass"
               id="register-name" v-model="userRegister.name"
               class="form-control" placeholder="昵称"/>
        <span v-show="registerNameValidate === false" class="text-danger">昵称2到20位中文，字母，数字，下划线组合</span>
        <input v-on:blur="onRegisterEmailBlur()"
               v-bind:class="registerEmailValidateClass"
               id="register-email" v-model="userRegister.email"
               class="form-control" placeholder="电子邮箱"/>
        <span v-show="registerEmailValidate === false" class="text-danger">输入正确的邮箱格式，且不能重复</span>
        <input v-on:blur="onRegisterPasswordBlur()"
               v-bind:class="registerPasswordValidateClass"
               id="register-password" v-model="userRegister.passwordOriginal"
               class="form-control" placeholder="密码" type="password"/>
        <span v-show="registerPasswordValidate === false" class="text-danger">密码最少6位，包含至少1字母和1个数字</span>
        <input v-on:blur="onRegisterConfirmPasswordBlur()"
               v-bind:class="registerConfirmPasswordValidateClass"
               id="register-confirm-password" v-model="userRegister.confirm"
               class="form-control" placeholder="确认密码" type="password"/>
        <span v-show="registerConfirmPasswordValidate === false" class="text-danger">确认密码和密码一致</span>
        <div class="form-check" style="margin: 0.5rem 0">
          <label class="form-check-label">
            <input type="checkbox" class="form-check-input" checked="checked" style="margin-top: 0.5rem"/>
            <span style="color: #717171; font-size: 0.85rem;">我已同意<a href="#">《噼哩噼哩视频网用户使用协议》</a>和<a
                    href="#">《噼哩噼哩隐私政策》</a></span>
          </label>
        </div>
        <button type="button" class="btn form-control" id="registerBtn2" v-on:click="register()">注册</button>
        <router-link to="/login" style="float: right; font-size: 0.85rem; margin-top: 0.5rem;">已有账号，直接登录></router-link>
      </div>
    </div>
  </main>
</template>

<script>
  export default {
    name: 'register',
    data: function () {
      return {
        user: {},
        userRegister: {},

        // 注册框显示错误信息
        registerEmailValidate: null,
        registerEmailCodeValidate: null,
        registerPasswordValidate: null,
        registerNameValidate: null,
        registerConfirmPasswordValidate: null,
      }
    },

    computed: {
      registerEmailValidateClass: function () {
        return {
          'border-success': this.registerEmailValidate === true,
          'border-danger': this.registerEmailValidate === false,
        }
      },
      registerPasswordValidateClass: function () {
        return {
          'border-success': this.registerPasswordValidate === true,
          'border-danger': this.registerPasswordValidate === false,
        }
      },
      registerNameValidateClass: function () {
        return {
          'border-success': this.registerNameValidate === true,
          'border-danger': this.registerNameValidate === false,
        }
      },
      registerConfirmPasswordValidateClass: function () {
        return {
          'border-success': this.registerConfirmPasswordValidate === true,
          'border-danger': this.registerConfirmPasswordValidate === false,
        }
      },
    },
    
    mounted() {
      let _this = this;
    },
    methods: {

      register() {
        let _this = this;

        // 提交之前，先校验所有输入框
        // 注意：当有一个文本框校验为false时，其它不校验
        let validateResult = _this.onRegisterEmailBlur() &&
            _this.onRegisterNameBlur() &&
            _this.onRegisterPasswordBlur() &&
            _this.onRegisterConfirmPasswordBlur();
        if (!validateResult) {
          return;
        }

        _this.userRegister.password = hex_md5(_this.userRegister.passwordOriginal + KEY);

        // 调服务端注册接口
        _this.$ajax.post('http://localhost:9000/business/web/user/register', _this.userRegister).then((response) => {
          let resp = response.data;
          if (resp.success) {
            toast.success("注册成功");
            _this.$router.push('/login');
          } else {
            toast.warning(resp.message);
          }
        })
      },

      //-------------------------------- 注册框校验 ----------------------------
      onRegisterEmailBlur() {
        let _this = this;
        _this.registerEmailValidate = Pattern.validateEmail(_this.userRegister.email);
        return _this.registerEmailValidate;
      },

      onRegisterNameBlur() {
        let _this = this;
        _this.registerNameValidate = Pattern.validateName(_this.userRegister.name);
        return _this.registerEmailValidate;
      },

      onRegisterPasswordBlur() {
        let _this = this;
        _this.registerPasswordValidate = Pattern.validatePasswordWeak(_this.userRegister.passwordOriginal);
        return _this.registerEmailValidate;
      },

      onRegisterConfirmPasswordBlur() {
        let _this = this;
        let confirmPassword = $("#register-confirm-password").val();
        if (Tool.isEmpty(confirmPassword)) {
          return _this.registerConfirmPasswordValidate = false;
        }
        return _this.registerConfirmPasswordValidate = (confirmPassword === _this.userRegister.passwordOriginal);
      },
    },
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