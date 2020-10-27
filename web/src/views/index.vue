<template>
  <main role="main">
    <div class="container">
      <div class="pili-banner">
        <div class="pili-banner-link">噼哩噼哩 (゜-゜)つロ 干杯~</div>
        <div class="pili-banner-btn">
          <div class="pili-banner-rank">
            <i class="fa fa-bar-chart">&nbsp;排行榜</i>
          </div>
          <div class="pili-banner-search">
            <input type="text" placeholder="这样的历史剧才离谱！">
            <i class="fa fa-search" style="width: 1.8rem; text-align: center"></i>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-1" style="border-right: solid 1px #E7E7E7">
          <div class="fa fa-home pili-category-home"></div>
          <br>
          <a href="#" style="font-size: 0.93rem; margin-left: 0.3rem">首页</a>
        </div>
        <div class="col-sm-8" style="border-right: solid 1px #E7E7E7">
          <ul class="pili-category-ul" style="margin-bottom: 2rem">
            <a href="#">动画&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">音乐&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">生活&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">时尚&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">电影&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">美食&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">搞笑&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">游戏&nbsp;<span class="badge badge-secondary">15</span></a>
          </ul>
          <ul class="pili-category-ul">
            <a href="#">数码&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">编程&nbsp;<span class="badge badge-secondary">125</span></a>
            <a href="#">绘画&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">外语&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">设计&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">心理&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">百科&nbsp;<span class="badge badge-secondary">15</span></a>
            <a href="#">摄影&nbsp;<span class="badge badge-secondary">15</span></a>
          </ul>
        </div>
        <div class="col-sm-3" style="z-index: -2">
          <img src="/static/image/bengdi.gif"/>
          <img src="/static/image/biga.gif" style="width: 76px;"/>
          <img src="/static/image/zou.gif" style="width: 76px;"/>
        </div>
      </div>
      <br>

      <div class="row">
        <div class="col-sm-6">
          <div id="demo" class="carousel slide" data-ride="carousel">

            <!-- 指示符 -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
            </ul>

            <!-- 轮播图片 -->
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="/static/image/carousel1.png">
              </div>
              <div class="carousel-item">
                <img src="/static/image/carousel2.jpg">
              </div>
              <div class="carousel-item">
                <img src="/static/image/carousel3.jpg">
              </div>
            </div>

            <!-- 左右切换按钮 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
              <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
              <span class="carousel-control-next-icon"></span>
            </a>

          </div>
        </div>

        <div class="col-sm-6">
          <div class="row pili-carousel-list">

            <div class="col-sm-4 pili-carousel-item" v-for="(o, index) in hots.slice(0, 6)">
              <router-link v-bind:to="'/detail?id=' + o.id">
                <img v-bind:src="o.image"/>
                <div class="pili-carousel-mask">
                  <span>{{o.name}}</span><br>
                  <span>up {{o.username}}</span>
                  <i class="fa fa-play-circle-o"></i>
                </div>
              </router-link>
            </div>

          </div>
        </div>
      </div>
      <br>

      <div>
        <span class="pili-head-i"></span>
        <span style="font-size: 1.6rem; margin-right: 1rem">推广</span>
        <span style="color: #7e858a; font-size: 0.8rem; line-height: 3.2rem;">最光荣的时刻，就是现在</span>
        <div class="row">
          <div class="col-sm-8">
            <div class="row pili-video-list">

              <div class="col-sm-3" v-for="(o, index) in news.slice(0, 4)">
                <router-link v-bind:to="'/detail?id=' + o.id">
                  <img v-bind:src="o.image"/>
                  <p>{{o.name}}</p>
                </router-link>
                <a href="#" style="color: #b5b5b5; font-size: 0.7rem;"><span>up</span>{{o.username}}</a>
              </div>

            </div>
          </div>

          <div class="col-sm-4">
            <a href="#">
              <img src="/static/image/tuiguang.jpg" width="100%">
            </a>
          </div>
        </div>
      </div>
      <br>

      <div>
        <div class="row">
          <div class="col-sm-8">
            <span class="pili-head-i-fun"></span>
            <span style="font-size: 1.6rem;">娱乐</span>
            <span class="video-list-btn">更多&nbsp;<i class="fa fa-angle-right"></i> </span>
            <span class="video-list-btn" style="margin-right: 1rem"><i
              class="fa fa-refresh fa-spin"></i>&nbsp;换一换</span>
            <div class="row pili-fun-list pili-video-list">

              <div class="col-sm-3" v-for="o in entertainmentNews.slice(0, 8)">
                <router-link v-bind:to="'/detail?id=' + o.id">
                  <img v-bind:src="o.image"/>
                  <p>{{o.name}}</p>
                </router-link>
                <a href="#" style="color: #b5b5b5; font-size: 0.7rem;"><span>up</span>{{o.userId}}</a>
              </div>

            </div>
          </div>
          <div class="col-sm-4">
            <div>
              <span style="font-size: 1.6rem; line-height: 2.2">排行榜</span>
              <span class="video-list-btn">更多&nbsp;<i class="fa fa-angle-right"></i> </span>
            </div>
            <div class="pili-fun-rank">
              <p v-for="(o, index) in entertainmentHots.slice(0, 10)"><span>{{index}}</span>
                <router-link v-bind:to="'/detail?id=' + o.id">{{o.name}}</router-link>
              </p>
            </div>
          </div>
        </div>
      </div>
      <br>

      <div>
        <div class="row">
          <div class="col-sm-8">
            <span class="pili-head-i-study"></span>
            <span style="font-size: 1.6rem;">学习</span>
            <span class="video-list-btn">更多&nbsp;<i class="fa fa-angle-right"></i> </span>
            <span class="video-list-btn" style="margin-right: 1rem"><i
              class="fa fa-refresh fa-spin"></i>&nbsp;换一换</span>
            <div class="row pili-fun-list pili-video-list">

              <div class="col-sm-3" v-for="o in studyNews.slice(0, 8)">
                <router-link v-bind:to="'/detail?id=' + o.id">
                  <img v-bind:src="o.image"/>
                  <p>{{o.name}}</p>
                </router-link>
                <a href="#" style="color: #b5b5b5; font-size: 0.7rem;"><span>up</span>{{o.username}}</a>
              </div>

            </div>
          </div>
          <div class="col-sm-4">
            <div>
              <span style="font-size: 1.6rem; line-height: 2.2">排行榜</span>
              <span class="video-list-btn">更多&nbsp;<i class="fa fa-angle-right"></i> </span>
            </div>
            <div class="pili-fun-rank">

              <p v-for="(o, index) in studyHots.slice(0, 10)"><span>{{index}}</span>
                <router-link v-bind:to="'/detail?id=' + o.id">{{o.name}}</router-link>
              </p>

            </div>
          </div>
        </div>
      </div>
    </div>
    <br>
  </main>
</template>

<script>

  $(document).ready(function () {

    $(".pili-carousel-item").mouseover(function () {
      $(this).find(".pili-carousel-mask").show();
    });

    $(".pili-carousel-item").mouseout(function () {
      $(this).find(".pili-carousel-mask").hide();
    })

  });

  export default {
    name: 'index',
    data: function () {
      return {
        news: [],
        hots: [],
        studyHots: [],
        entertainmentHots: [],
        studyNews: [],
        entertainmentNews: [],
      }
    },

    mounted() {
      let _this = this;
      _this.listNew();
      _this.listHot();
      _this.listEntertainmentHots();
      _this.listEntertainmentNews();
      _this.listStudyNews();
      _this.listStudyHots();
    },

    methods: {

      listNew() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/listNew').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.news = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      listHot() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/hotList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.hots = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      listStudyHots() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/hotStudyList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.studyHots = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      listEntertainmentHots() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/hotEntertainmentList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.entertainmentHots = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

      listStudyNews() {
        let _this = this;
        _this.$ajax.get('http://localhost:9000/business/web/video/newStudyList').then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.studyNews = resp.content.records;
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
            _this.entertainmentNews = resp.content.records;
          }
        }).catch((response) => {
          console.log("error：", response);
        })
      },

    }
  }
</script>

<style>
  a {
    color: #252525;
  }

  #contributionBtn {
    background-color: #00a1d6;
  }

  #contributionBtn:hover {
    background-color: #1aabda;
  }

  .pili-fun-rank span {
    color: #999999;
    font-size: 0.9rem;
    margin-right: 0.6rem;
  }

  .pili-fun-rank p {
    font-size: 0.95rem;
  }

  .pili-fun-list div {
    margin-top: 0.7rem;
  }

  .video-list-btn {
    margin-top: 1rem;
    color: #505050;
    font-size: 0.8rem;
    border: solid 1px #505050;
    border-radius: 2px;
    padding: 0.1rem 0.5rem;
    cursor: pointer;
    float: right;
  }

  .video-list-btn:hover {
    background-color: #f4f4f4;
  }

  .pili-head-i-fun {
    background: url(icons.aef9bb0.png) no-repeat;
    background-position: -141px -908px;
    width: 40px;
    height: 39px;
    display: inline-block;
    vertical-align: middle;
    margin-right: 10px;
  }

  .pili-head-i-study {
    background: url(icons.aef9bb0.png) no-repeat;
    background-position: -141px -525px;
    width: 40px;
    height: 39px;
    display: inline-block;
    vertical-align: middle;
    margin-right: 10px;
  }

  .pili-video-list img {
    width: 100%;
    height: 110px;
    border-radius: 4px;
  }

  .pili-video-list span {
    border: solid 1px #b5b5b5;
    border-radius: 3px;
    margin-right: 0.4rem;
  }

  .pili-video-list p {
    font-size: 0.8rem;
  }

  .pili-head-i {
    background: url(icons.aef9bb0.png) no-repeat;
    background-position: -141px -75px;
    width: 40px;
    height: 39px;
    display: inline-block;
    vertical-align: middle;
    margin-right: 10px;
  }

  .pili-carousel-mask {
    position: absolute;
    height: 100%;
    width: 85%;
    bottom: 0;
    display: none;
    border-radius: 4px;
    padding: 0.2rem;
    background: rgba(47, 13, 26, 0.9);
  }

  .pili-carousel-item {
    position: relative;
  }

  .pili-carousel-item:nth-child(-n+3) {
    margin-bottom: 0.9rem;
  }

  .pili-carousel-item div span {
    font-size: 0.78rem;
    color: white;
  }

  .pili-carousel-list img {
    width: 100%;
    height: 110px;
    border-radius: 4px;
  }

  .pili-carousel-mask i {
    color: #ffffff;
    position: absolute;
    right: 1rem;
    font-size: 1.5rem;
    bottom: 0.5rem;
  }

  .pili-category-home {
    width: 2.5rem;
    height: 2.5rem;
    color: #ffffff;
    line-height: 2.5rem;
    font-size: 1.8rem;
    text-align: center;
    background-color: #FF5C7C;
    border-radius: 50%;
  }

  .pili-category-ul a {
    display: block;
    float: left;
    width: 10%;
    margin-right: 1rem;
    font-size: 0.9rem;
  }

  .pili-category-ul span {
    background-color: #73C9E5;
  }

  .pili-banner-search {
    float: right;
    cursor: pointer;
  }

  .pili-banner-search input {
    font-size: 0.9rem;
    height: 1.9rem;
    border: solid 1px #E0E0E0;
    outline: none;
  }

  .pili-banner {
    position: relative;
    height: 12rem;
    color: #F25D8E;
  }

  .pili-banner-btn {
    position: absolute;
    bottom: 2rem;
    right: 2rem;
    border-radius: 4px;
    border: solid 0.5px #E0E0E0;
  }

  .pili-banner-link {
    background-color: #525252;
    width: 12rem;
    height: 2rem;
    text-align: center;
    font-size: 0.91rem;
    line-height: 2rem;
    border-radius: 4px;
    color: #ffffff;
    position: absolute;
    bottom: 2rem;
    left: 12rem;
    cursor: pointer;
  }

  .pili-banner-rank {
    border: solid 1px #E0E0E0;
    border-radius: 4px;
    font-size: 0.9rem;
    width: 4.6rem;
    height: 1.9rem;
    line-height: 1.9rem;
    text-align: center;
    cursor: pointer;
    float: left;
  }
</style>
