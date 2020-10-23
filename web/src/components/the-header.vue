<template>
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="/index">
          <i class="fa fa-github-alt"></i>&nbsp;主站
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">娱乐</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="#">学习</a>
            </li>
            <li class="nav-item dropdown active">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                 aria-haspopup="true" aria-expanded="false">
                更多
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">关于我们</a>
                <a class="dropdown-item" href="#">渠道合作</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">更多信息</a>
              </div>
            </li>
          </ul>
          <ul class="navbar-nav">
            <img v-show="!loginMember.id" src="/static/image/nologin.jpg" class="no-avatar-img"/>
            <li v-show="!loginMember.id" class="nav-item active">
              <a class="nav-link" href="/login">登录</a>
            </li>
            <li v-show="!loginMember.id" class="nav-item active">
              <a class="nav-link" href="/register">注册</a>
            </li>


            <span v-show="loginMember.id">
              <li class="nav-item active avatar-li">
              <img v-show="!loginMember.avatar" src="/static/image/avatar.jpg" class="avatar-img"/>
                <img v-show="loginMember.avatar" v-bind:src="loginMember.avatar" class="avatar-img"/>
              <div class="user-info">
                <p style=" color: #FB7299; font-weight: bold; margin-bottom: -0.3rem">{{loginMember.name}}</p>
                <span class="badge badge-secondary" style="background-color: #FB7299; font-size: 0.6rem">管理员</span>
                <hr>
                <ul class="user-info-ul">
                  <router-link to="/contribution" target="_blank">
                    <div style="margin-right: 1rem">
                      <span>投稿</span>
                      <p>8</p>
                    </div>
                  </router-link>
                  <div>
                    <span>粉丝</span>
                    <p>41</p>
                  </div>
                  <div>
                    <span>关注</span>
                    <p>141</p>
                  </div>
                </ul>
                <hr>
                <div class="user-info-div" style="text-align: left">
                  <router-link to="/account" target="_blank">
                    <div><i class="fa fa-user-o"></i> <span> &nbsp;个人中心</span></div>
                  </router-link>
                  <router-link to="/contribution" target="_blank">
                    <div><i class="fa fa-file-video-o"></i> <span> &nbsp;投稿管理</span></div>
                  </router-link>
                  <hr>
                  <div v-on:click="logout()"><i class="fa fa-power-off"></i> <span> &nbsp;退出</span></div>
                </div>
              </div>
            </li>
            </span>

            <li class="nav-item active">
              <span class="nav-link contribution-btn" data-toggle="modal" data-target="#contributionModal">投稿</span>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- 模态框 -->
    <div class="modal fade" id="contributionModal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">

          <!-- 模态框头部 -->
          <div class="modal-header">
            <h4 class="modal-title">视频投稿</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- 模态框主体 -->
          <div class="modal-body" style="padding: 2rem">
            <form class="form-horizontal">
              <div class="form-group">
                <label>
                  分类
                </label>
                <div>
                  <ul id="tree" class="ztree"></ul>
                </div>
              </div>
              <div class="form-group">
                <!--<label class="control-label">封面</label>-->
                <div>
                  <big-file v-bind:input-id="'image-upload'"
                            v-bind:text="'上传封面'"
                            v-bind:use="'C'"
                            v-bind:suffixs="['jpg', 'jpeg', 'png']"
                            v-bind:after-upload="afterUpload1"></big-file>
                  <div v-show="video.image" class="row">
                    <div class="col-md-6">
                      <img v-bind:src="video.image"  class="img-responsive">
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <!--<label class="control-label">视频</label>-->
                <div>
                  <big-file v-bind:input-id="'video-upload'"
                            v-bind:text="'上传视频'"
                            v-bind:use="'S'"
                            v-bind:suffixs="['mp4']"
                            v-bind:after-upload="afterUpload2"></big-file>
                  <div v-show="video.url" class="row">
                    <div class="col-md-6">
                      <video v-bind:src="video.url" id="video" controls="controls"></video>
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label>标题</label>
                <input type="text" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label>简介</label>
                <textarea class="form-control"></textarea>
              </div>
              <div class="form-group">
                <label>时长</label>
                <input type="text" class="form-control" readonly="readonly">
              </div>
            </form>
          </div>

          <!-- 模态框底部 -->
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" id="contributionBtn">立即投稿</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          </div>

        </div>
      </div>
    </div>
  </header>
</template>

<script>

  $(document).ready(function () {

    $(".avatar-img").mouseenter(function () {
      $(".avatar-img").attr("class", "avatar-img-h");
      $(".user-info").show();
    })
    $(".user-info").mouseleave(function () {
      $(".avatar-img-h").attr("class", "avatar-img");
      $(".user-info").hide();
    })

  });

  import BigFile from '../components/big-file.vue'

  export default {
    name: 'theHeader',
    components: {BigFile},
    data: function () {
      return {
        loginMember: {},
        video: {},
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

      logout() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/user/logout/' + _this.loginMember.token).then((response) => {
          let resp = response.data;
          if (resp.success) {
            Tool.setLoginMember(null);
            _this.loginMember = {};
            toast.success("退出登录成功");
            _this.$router.push("/index");
          } else {
            toast.warning(resp.message);
          }
        });
      },

      afterUpload1(resp) {
        let _this = this;
        let image = resp.content.path;
        _this.video.image = image;
        console.log(image);
        console.log(_this.video.image)
      },

      afterUpload2(resp) {
        let _this = this;
        let url = resp.content.path;
        _this.video.url = url;
        console.log(url);
        console.log(_this.video.url)
      },

    }
  }
</script>

<style>
  .user-info-div {
    z-index: 6;
  }

  .user-info-div span {
    color: #212121;
    font-size: 0.96rem;
  }

  .user-info-div div {
    height: 2.5rem;
    padding-top: 0.5rem;
  }

  .user-info-div div:hover {
    background-color: #F4F4F4;
  }

  .user-info-div i {
    color: #979797;
    font-size: 1.3rem;
    margin-left: 2rem;
  }

  .user-info-ul {
    margin-left: -2rem;
    height: 3rem;
    margin-bottom: -0.5rem;
    margin-top: -0.6rem;
  }

  .user-info-ul div {
    float: right;
    width: 4.6rem;
  }

  .user-info-ul span {
    color: #999999;
    font-size: 0.7rem;
  }

  .user-info-ul div:hover {
    color: #1890ff;
  }

  .user-info-ul p {
    font-weight: bold;
  }

  .avatar-img {
    width: 2.3rem;
    height: 2.3rem;
    border-radius: 50%;
    cursor: pointer;
  }

  .no-avatar-img {
    width: 2.3rem;
    height: 2.3rem;
    border-radius: 50%;
    cursor: pointer;
  }

  .user-info {
    background-color: #ffffff;
    width: 16rem;
    cursor: pointer;
    text-align: center;
    height: auto;
    box-shadow: 0 3px 6px rgba(0, 0, 0, .2) !important;
    position: absolute;
    top: 3rem;
    z-index: 9;
    right: -7rem;
    padding-top: 1.5rem;
    padding-bottom: 0.6rem;
    display: none;
  }

  .contribution-btn {
    text-align: center;
    border-radius: 2px;
    margin-left: 1rem;
    cursor: pointer;
    width: 6rem;
    height: 100%;
    background-color: #FB7299;
  }

  .avatar-li {
    position: relative;
  }

  .avatar-img-h {
    width: 3.6rem;
    height: 3.6rem;
    border-radius: 50%;
    cursor: pointer;
    position: absolute;
    top: 0.5rem;
    right: -0.5rem;
    z-index: 10;
  }

  video {
    width: 100%;
    height: auto;
    margin-top: 10px;
  }

  .img-responsive {
    display: block;
    max-width: 100%;
    height: auto;
    margin-top: 1rem;
  }
</style>