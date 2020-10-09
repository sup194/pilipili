<template>
  <main role="main" style="margin: 6rem">
    <div class="container">
      <div class="pili-security">
        <div class="pili-security-left">
          <div class="pili-security-title">
            个人中心
          </div>
          <ul class="list-inline pili-security-ul">
            <router-link to="/account"><li>我的信息</li></router-link>
            <li>投稿管理</li>
            <li style="border-bottom: solid 1px #e1e2e5" class="pili-security-active">修改密码</li>
          </ul>
        </div>
        <div class="pili-security-right">
          <div class="pili-security-right-title">
            <span class="pili-security-right-title-icon"></span>
            <span class="pili-security-right-title-text">修改密码</span>
          </div>
          <div class="pili-user-setting-warp">
            <form>
              <div class="form-group row">
                <label for="passwordOld"
                       class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;原密码：</label>
                <div class="col-sm-8">
                  <input type="password" class="form-control" id="passwordOld">
                </div>
              </div>
              <div class="form-group row">
                <label for="passwordNew"
                       class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新密码：</label>
                <div class="col-sm-8">
                  <input type="password" class="form-control" id="passwordNew">
                </div>
              </div>
              <div class="form-group row">
                <label for="passwordConfirm" class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码：</label>
                <div class="col-sm-8">
                  <input type="password" class="form-control" id="passwordConfirm">
                </div>
              </div>
              <br>
              <hr>
              <button id="confirmBtn">确认</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
  export default {
    name: 'security',
  }
</script>

<style>
  #confirmBtn {
    width: 110px;
    color: white;
    cursor: pointer;
    border: 1px solid #c4c4c4;
    background: #00a1d6;
    height: 36px;
    border-radius: 6px;
    margin: 3rem 36%;
  }

  #confirmBtn:hover {
    background-color: #00b5e5;
  }

  .pili-user-setting-warp {
    font-size: 14px;
    color: #48576a;
    margin-bottom: 10rem;
    margin-top: 3rem;
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