<template>
  <main role="main" style="margin: 6rem">
    <div class="container">
      <div class="pili-security">
        <div class="pili-security-left">
          <div class="pili-security-title">
            个人中心
          </div>
          <ul class="list-inline pili-security-ul">
            <li class="pili-security-active">我的信息</li>
            <router-link to="/contribution">
              <li>投稿管理</li>
            </router-link>
            <router-link to="/security">
              <li style="border-bottom: solid 1px #e1e2e5">修改密码</li>
            </router-link>
          </ul>
        </div>
        <div class="pili-security-right">
          <div class="pili-security-right-title">
            <span class="pili-security-right-title-icon"></span>
            <span class="pili-security-right-title-text">我的信息</span>
          </div>
          <div class="pili-user-setting-warp">
            <form>
              <div style="text-align: center; margin-bottom: 3rem;">
                <div class="pili-tool-avatar-box">
                  <div class="pili-change-avatar">
                    更换<br>
                    头像
                  </div>
                  <img class="pili-user-avatar" v-bind:src="loginMember.avatar">
                </div>
              </div>
              <div class="form-group row">
                <label for="username"
                       class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称：</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="username" style="font-size: 14px" v-model="loginMember.name">
                </div>
              </div>
              <div class="form-group row">
                <label for="sign" class="col-sm-2 col-form-label">我的签名：</label>
                <div class="col-sm-8">
                  <textarea class="form-control" rows="3" id="sign" style="font-size: 14px" v-model="loginMember.sign"></textarea>
                </div>
              </div>
              <br>
              <hr>
              <button id="saveBtn">保存</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
  export default {
    name: 'account',

    data: function () {
      return {
        loginMember: {}
      }
    },

    mounted() {
      let _this = this;
      _this.loginMember = Tool.getLoginMember();
    },

    methods: {

      setLoginMember(loginMember) {
        let _this = this;
        _this.loginMember = loginMember;
      },

    },

  }
</script>

<style>
  #saveBtn {
    width: 110px;
    color: white;
    cursor: pointer;
    border: 1px solid #c4c4c4;
    background: #00a1d6;
    height: 36px;
    border-radius: 6px;
    margin: 3rem 36%;
  }

  #saveBtn:hover {
    background-color: #00b5e5;
  }

  .pili-change-avatar {
    width: 54px;
    height: 54px;
    padding-top: 5px;
    border-radius: 50%;
    color: white;
    background-color: #00a1d6;;
    position: absolute;
    left: -30px;
    top: 53px;
    cursor: pointer;
  }

  .pili-tool-avatar-box {
    width: 170px;
    height: 170px;
    position: relative;
    left: 30%;
    border: 1px solid #e5e9ef;
    border-radius: 50%;
  }

  .pili-user-avatar {
    position: absolute;
    top: 30px;
    right: 28px;
    width: 110px;
    height: 110px;
    border-radius: 50%;
  }

  .pili-user-setting-warp {
    font-size: 14px;
    color: #48576a;
    margin-bottom: 10rem;
  }

  .pili-security-ul {
    width: 100%;
  }

  .pili-security-ul li {
    height: 48px;
    line-height: 48px;
    font-size: 14px;
    text-align: center;
    cursor: pointer;
  }

  .pili-security-ul li:hover {
    background-color: #00a1d7;
    color: #ffffff;
  }

  .pili-security {
    overflow: hidden;
    width: 100%;
    height: 100%;
    border: 1px solid #e1e2e5;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .14);
    background: #fafafa;
    border-radius: 4px;
  }

  .pili-security-title {
    border-bottom: 1px solid #ddd;
    height: 50px;
    text-align: center;
    line-height: 50px;
    font-size: 16px;
    color: #99a2aa;
    cursor: default;
  }

  .pili-security-left {
    float: left;
    overflow: hidden;
    /*width: 150px*/
    width: 15%;
  }

  .pili-security-right {
    border-left: 1px solid #ddd;
    width: 85%;
    /*width: 828px;*/
    float: left;
  }

  .pili-security-right-title {
    height: 50px;
    border-bottom: solid 1px #dddddd;
    padding-left: 30px;
  }

  .pili-security-right-title-icon {
    float: left;
    width: 4px;
    height: 16px;
    margin-top: 18px;
    background-color: #00a1d6;
    border-radius: 4px
  }

  .pili-security-right-title-text {
    float: left;
    margin: 15px 0 0 5px;
    color: #00a1d6;
    font-size: 14px;
    cursor: default;
  }

  .pili-security-active {
    background-color: #00a1d7;
    color: #ffffff;
  }

  .pili-user-setting-warp {
    padding: 20px 60px;
  }
</style>