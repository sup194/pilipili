<template>
  <footer class="text-muted">
    <div style="background-color: #f6f9fa; padding-top: 2rem;">
      <div class="container">
        <div class="row footer-list">
          <div class="col-sm-4" style="border-right: solid 1px #eeeeee">
            <span>pilipili</span>
            <div class="row" style="margin-top: 0.8rem">
              <div class="col-sm-5">
                <ul>
                  <a href="#">关于我们</a>
                  <a href="#">联系我们</a>
                  <a href="#">用户协议</a>
                  <a href="#">加入我们</a>
                </ul>
              </div>
              <div class="col-sm-7">
                <ul>
                  <a href="#">友情链接</a>
                  <a href="#">隐私政策</a>
                  <a href="#">pilipili认证</a>
                  <a href="#">Investor Relations</a>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-sm-5" style="border-right: solid 1px #eeeeee">
            <span>传送门</span>
            <div class="row" style="margin-top: 0.8rem">
              <div class="col-sm-4">
                <ul>
                  <a href="#">帮助中心</a>
                  <a href="#">高级视频</a>
                  <a href="#">活动专题</a>
                  <a href="#">侵权申述</a>
                </ul>
              </div>
              <div class="col-sm-4">
                <ul>
                  <a href="#">活动中心</a>
                  <a href="#">用户反馈</a>
                  <a href="#">壁纸站</a>
                  <a href="#">广告合作</a>
                </ul>
              </div>
              <div class="col-sm-4">
                <ul>
                  <a href="#">名人堂</a>
                  <a href="#">管理中心</a>
                </ul>
              </div>
            </div>
          </div>
          <div class="rol-sm-3 footer-icon">
            <i class="fa fa-github"></i>
            <i class="fa fa-weibo" style="margin: 0 2rem"></i>
            <i class="fa fa-weixin"></i>
          </div>
        </div>
        <p class="footer-p">
          © 2020 PiliPili视频网站. ALL RIGHTS RESERVED.
        </p>
      </div>
    </div>
  </footer>
</template>

<script>

  export default {
    name: 'theFooter',
  }
</script>

<style>
  .footer-p {
    display: block;
    color: #b2a1a6;
    font-size: 0.85rem;
    margin-top: 0.5rem;
    padding-left: 2.5rem;
    padding-bottom: 1rem;
    margin-bottom: -1rem
  }

  .footer-list span {
    color: #999999;
    padding-left: 2.5rem;
  }

  .footer-list a {
    display: block;
    color: #212121;
    font-size: 0.87rem;
    margin-bottom: 0.6rem;
  }

  a:hover {
    color: #4fa1d6;
    text-decoration: none;
  }

  .footer-icon {
    font-size: 3rem;
    padding-left: 2rem;
    padding-top: 2rem;
  }

  .footer-icon i {
    cursor: pointer;
  }
</style>
