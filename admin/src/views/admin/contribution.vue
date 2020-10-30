<template>
  <div>
    <p>
      <button class="btn btn-app btn-purple btn-xs">
        <i class="ace-icon fa fa-cloud-upload"></i>
        新增
      </button>
      &nbsp;
      <button v-on:click="list(1)" class="btn btn-app btn-success btn-xs">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
      <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"
                  style="float: right; margin-top: 2rem"></pagination>
    </p>

    <div class="row">

      <div class="col-sm-3" style="margin-bottom: 2rem" v-for="contribution in contributions">
        <span class="badge badge-danger" style="font-size: 14px; position: absolute; top: 5px; right: 17px">ID: {{contribution.id}}</span>
        <video v-bind:src="contribution.url"
               controls="controls" width="100%" class="pili-contribution-video">
          您的浏览器不支持 video 标签。
        </video>
        <a class="pili-contribution-title"><span class="badge badge-pink"
                                                 style="font-weight: bold">{{CONTRIBUTION_STATUS | optionKV(contribution.status)}}</span>
          {{contribution.name}}</a>
        <span class="pili-contribution-time">投稿于： {{(contribution.createdAt) | formatDate}}， &nbsp;&nbsp;&nbsp; UP：  {{contribution.username}}</span>
        <i class="fa fa-ellipsis-v pili-contribution-icon" @click="toggle(contribution)">
          <div class="pili-contribution-operate" v-if="contribution.show">
            <ul class="list-inline">
              <li>通过</li>
              <li>下架</li>
              <li>驳回</li>
            </ul>
          </div>
        </i>
      </div>

    </div>
    <br>

  </div>
</template>

<script>

  import Pagination from "../../components/pagination";

  export default {
    components: {Pagination},
    name: "business-contribution",
    data: function () {
      return {
        contribution: {},
        contributions: [],
        CONTRIBUTION_STATUS: CONTRIBUTION_STATUS
      }
    },

    mounted: function () {
      let _this = this;
      _this.$refs.pagination.size = 8;
      _this.list(1);
      // sidebar激活样式方法一
      // this.$parent.activeSidebar("business-course-sidebar");
    },

    methods: {

      toggle: function(item) {
        item.show = !item.show;
      },

      /**
       * 列表查询
       */
      list(page) {
        let _this = this;
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/video/list', {
          current: page,
          size: _this.$refs.pagination.size,
        }).then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.contributions = resp.content.records;
          _this.$refs.pagination.render(page, resp.content.total);

        })
      },

      /**
       * 点击【删除】
       */
      del(id) {
        let _this = this;
        Confirm.show("删除课程后不可恢复，确认删除？", function () {
          Loading.show();
          _this.$ajax.delete(process.env.VUE_APP_SERVER + '/business/admin/course/delete/' + id).then((response) => {
            Loading.hide();
            let resp = response.data;
            if (resp.success) {
              _this.list(1);
              toast.success("删除成功！");
            }
          })
        });
      },

    }
  }


</script>

<style scoped>
  .caption h3 {
    font-size: 20px;
  }

  @media (max-width: 1199px) {
    .caption h3 {
      font-size: 16px;
    }
  }

  .pili-contribution-title {
    display: block;
    line-height: 20px;
    height: 38px;
    margin: 6px 0;
    overflow: hidden;
    color: #222;
    font-size: 15px;
  }

  .pili-contribution-time {
    font-size: 12px;
    overflow: hidden;
    text-overflow: ellipsis;
    color: #999;
    white-space: nowrap;
    height: 14px;
    line-height: 14px;
  }

  .pili-contribution-icon {
    position: relative;
    font-size: 13px;
    color: #999999;
    float: right;
    margin-top: 5px;
    font-weight: bold;
    cursor: pointer;
  }

  .pili-contribution-operate {
    /*display: none;*/
    font-weight: normal;
    position: absolute;
    z-index: 10;
    padding: 6px 0;
    background-color: #fff;
    border: 1px solid #e5e9ef;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .14);
    width: 98px;
    height: 134px;
    text-align: center;
    font-size: 14px;
    color: #222;;
    right: -7px;
  }

  .pili-contribution-video {
    border-radius: 4px;
    height: 14rem;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .16);
    border: 1px solid #e5e9ef;
  }

  .pili-contribution-operate li {
    height: 40px;
    padding: 0 20px;
    width: 100%;
    line-height: 40px;
    cursor: pointer;
  }

  .pili-contribution-operate li:hover {
    background-color: #e5e9ef;
    color: #15a7d8;
  }
</style>