<template>
  <main role="main">
    <div class="container" style="margin-top: 2rem">
      <div class="row">
        <div class="col-sm-9">
          <span class="pili-tit">{{video.name}}</span><br>
          <span class="pili-video-data">{{video.playback}}播放&nbsp;·&nbsp;90评论&nbsp;{{video.createdAt}}</span>
          <div class="video-box" style="margin-top: 1rem; margin-bottom: 0.6rem">
            <video-player class="video-player vjs-custom-skin" ref="videoPlayer" :playsinline="true"
                          :options="playerOptions"></video-player>
          </div>
          <div class="pili-label">
            <span v-for="o in video.categories">{{o.name}}</span>
          </div>
          <hr>
          <div class="pili-comment-head">
            <span>6 评论</span>
          </div>
          <ul class="pili-comment-sort list-inline">
            <li class="pili-hot-sort pili-sort-on">按热度排序</li>
            <li class="pili-new-sort">按时间排序</li>
          </ul>
          <br>
          <hr>
          <div>
            <div style="float: left; padding: 5px 20px">
              <img v-bind:src="loginMember.avatar" width="48" height="48" style="border-radius: 50%">
            </div>
            <div style="width: 77%; float: left">
              <textarea v-model="comment.content" class="form-control" rows="3" placeholder="发条友善的评论" style="font-size: 12px; color: #555;"></textarea>
            </div>
            <div style="float: left; margin-left: 1rem">
              <button type="button" class="btn" id="commentBtn" v-on:click="addComment()">发表<br>评论</button>
            </div>
          </div>

          <div style="padding-left: 10.6%; margin-top: 7rem">
            <hr>
          </div>

          <div class="pili-comment-list">

            <div class="pili-comment-list-item" v-for="o in comments">
              <div style="float: left; margin:0 1.5rem 0 1.3rem"><img src="/static/image/avatar.jpg" width="48"
                                                                      height="48"/></div>
              <div style="float: left; width: 80%">
                <a>{{o.userId}}</a><br>
                <span>{{o.content}}</span>
                <p>2020-10-05 09:10:48</p>
                <div style="width: 111%; padding-bottom: 1rem">
                  <hr>
                </div>
              </div>
            </div>

          </div>
        </div>
        <div class="col-sm-3">
          <div style="float:left; display:inline">
            <img v-bind:src="user.avatar" width="60" height="60" style="border-radius: 50%"/>
          </div>
          <div style="float:left; display:inline; width: 70%; padding: 5px 0 0 7px">
            <span class="pili-username">{{user.username}}</span><br>
            <span class="pili-desc">{{user.sign}}</span>
          </div>
          <br><br><br>
          <div class="pili-rec-title">
            相关推荐
          </div>

          <div>

            <div style="height: 98px" v-for="o in recommendList">
              <div style="width: 45%; float: left;" >
                <img v-bind:src="o.image" width="100%"
                     height="90"/>
              </div>
              <div style="float: right; width: 53%" class="pili-rec-info">
                <router-link v-bind:to="'/detail?id=' + o.id" target="_blank">{{o.name}}</router-link>
                <span>{{o.username}}</span><br>
                <span>{{o.playback}} 播放 · 69 评论</span>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div><br><br>
  </main>
</template>

<script>
  export default {
    name: 'detail',
    data() {
      return {
        id: "",
        video: {},
        user: {},
        comment: {},
        comments: [],
        recommendList: [],
        loginMember: {},
        playerOptions: {
          playbackRates: [0.7, 1.0, 1.5, 2.0], //播放速度
          autoplay: false, //如果true,浏览器准备好时开始回放。
          muted: false, // 默认情况下将会消除任何音频。
          loop: false, // 导致视频一结束就重新开始。
          preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
          language: 'zh-CN',
          aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
          fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
          sources: [{
            type: "",
            // src: "https://online-pilipili.oss-cn-guangzhou.aliyuncs.com/course/E6HnsQM5.mp4"
            src: "" //视频url地址
          }],
          poster: "", //你的封面地址
          // width: document.documentElement.clientWidth,
          notSupportedMessage: '此视频暂无法播放，请稍后再试', //允许覆盖Video.js无法播放媒体源时显示的默认信息。
          controlBar: {
            timeDivider: true,
            durationDisplay: true,
            remainingTimeDisplay: false,
            fullscreenToggle: true  //全屏按钮
          }
        }
      }
    },

    mounted() {
      let _this = this;
      _this.id = _this.$route.query.id;
      _this.loginMember = Tool.getLoginMember();
      _this.findVideo();
      _this.findComment();
    },

    methods: {
      findVideo() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/detail/' + _this.id).then((response) => {
          let resp = response.data;
          _this.video = resp.content;
          _this.user = _this.video.userDto || {};
          _this.playerOptions.sources[0].src = _this.video.url;
          _this.playerOptions.poster = _this.video.image;
          if (_this.video.categories[0].parent === "00000100") {
            _this.listEntertainmentNews();
          } else {
            _this.listStudyNews();
          }
        })
      },

      listStudyNews() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/newStudyList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.recommendList = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      listEntertainmentNews() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/newEntertainmentList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.recommendList = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      findComment() {
        let _this = this;
          _this.$ajax.get('http://localhost:9000/business/web/comment/list/' + _this.id).then((response) => {
          let resp = response.data.content;
          _this.comments = resp.records;
          console.log(_this.comments);
        })
      },

      addComment() {
        let _this = this;
        _this.comment.userId = Tool.getLoginMember().id;
        _this.comment.videoId = _this.video.id;
        _this.$ajax.post('http://localhost:9000/business/web/comment/add', _this.comment).then((response) => {
          let resp = response.data;
          if (resp.success) {
            toast.success("发表评论成功！");
            _this.comment.content = "";
            _this.findComment();
          } else {
            toast.warning(resp.message)
          }
        })
      },

    },

  }
</script>

<style>
  .pili-tit {
    font-size: 18px;
    font-weight: 500;
    color: #212121;
  }

  .pili-video-data {
    font-size: 12px;
    color: #999;
  }

  .pili-username {
    font-size: 14px;
    color: #212121;
    font-weight: 500;
    display: inline-block;
    max-width: 180px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: top;
  }

  .pili-desc {
    margin-top: 4px;
    font-size: 12px;
    line-height: 16px;
    color: #999;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .pili-rec-title {
    font-size: 16px;
    color: #222;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-pack: justify;
    justify-content: space-between;
    margin-bottom: 1rem;
    margin-top: 2rem;
  }

  .pili-rec-info span {
    color: #999;
    font-size: 12px;
  }

  .pili-rec-info a {
    font-size: 14px;
    font-weight: 500;
    word-break: break-word;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
  }

  .pili-label span {
    color: #00a1d6;
    border-radius: 100px;
    padding: 0 12px;
    background-color: #f4f4f4;
    height: 22px;
    line-height: 22px;
    margin-right: 10px;
    font-size: 12px;
    border: 1px solid #f4f4f4;
    cursor: pointer;
  }

  .pili-label span:hover {
    border-color: #00a1d6;
  }

  .pili-comment-head {
    font-size: 18px;
    line-height: 24px;
    color: #222;
    margin: 0 0 20px;
  }

  .pili-comment-sort li {
    font-size: 14px;
    font-weight: 700;
    margin-right: 2rem;
    cursor: pointer;
    height: 2.5rem;
    width: auto;
    position: relative;
    float: left;
  }

  .pili-comment-sort li:hover {
    color: #00aae2;
  }

  .pili-sort-on {
    color: #00aae2;
    border-bottom: solid 2px #00aae2;
  }

  #commentBtn {
    color: #ffffff;
    font-size: 14px;
    background-color: #00a1d6;
    padding: 11px 20px;
  }

  .pili-comment-list-item a {
    color: #fb7299 !important;
    cursor: pointer;
    font-size: 12px;
    font-weight: 700;
  }

  .pili-comment-list-item p {
    color: #99a2aa;
    font-size: 12px;
    margin-top: 4px;
    margin-bottom: 1rem;
  }

  .pili-comment-list-item img {
    border-radius: 50%;
    cursor: pointer;
  }

  .pili-comment-list-item span {
    font-size: 14px;
    text-shadow: none;
  }
</style>
