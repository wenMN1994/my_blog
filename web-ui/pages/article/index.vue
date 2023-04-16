<template>
  <div id="app-container">
    <el-card>
      <el-row :gutter="20">
        <el-col :span="16">
          <div class="Community">
            <div class="active-blog" v-for="article in articleList" :key="article.id">
              <div class="Community-item-active">
                <a target="_blank" class="Community-h-tag" @click="articleItemClick(article.id)">
                  <span class="blog-text">{{article.articleTitle}}</span>
                </a>
                <div class="Community-item">
                  <div class="content">
                    <a target="_blank" @click="articleItemClick(article.id)">
                      <p class="desc">{{article.summary}}</p>
                    </a>
                    <div class="operation">
                      <p>
                        <img src="~/assets/img/common/articleReadEyes.png"> 
                        <span class="num ">122 浏览</span>
                      </p>
                      <p>
                        <img src="~/assets/img/common/comment.png"> 
                        <span class="num ">122 评论</span>
                      </p>
                      <p>
                        <img src="~/assets/img/common/zan.png"> 
                        <span class="num ">122 赞</span>
                      </p>
                      <p>
                        <img src="~/assets/img/common/cai.png"> 
                        <span class="num ">122 踩</span>
                      </p>
                    </div>
                  </div>
                  <div class="right">
                    <a target="_blank" @click="articleItemClick(article.id)">
                      <img alt class="img" :src="article.coverUrl">
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div class="block">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page.sync="currentPage"
                :page-size="pageSize"
                layout="prev, pager, next, jumper"
                :total="total">
              </el-pagination>
            </div>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="blog-slide-ad-box">
            <el-carousel height="230px">
              <el-carousel-item v-for="item in 4" :key="item">
                <h3 class="small">
                  <img src="https://s0.2mdn.net/simgad/3380672590489704266">
                </h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div class="blog-slide-ad-box">
            <div class="template">
              <div class="template-title">
                <span>热门推荐</span>
              </div>
              <div class="template-cont" v-for="item in 4" :key="item">
                <a target="_blank" @click="articleItemClick(1)">
                  <img src="https://img-bss.csdn.net/1642139156620.jpg">
                  <p>详细后端开发知识讲解</p>
                </a>
              </div>
            </div>
          </div>
          <div class="blog-slide-ad-box">
            <div class="template">
              <div class="template-title">
                <span>猜你喜欢</span>
              </div>
              <div class="template-cont" v-for="item in 4" :key="item">
                <a target="_blank" @click="articleItemClick(1)">
                  <img src="https://img-bss.csdn.net/1642139177006.jpg">
                  <p>后端成长之路：从菜鸟到架构</p>
                </a>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>
<script>
import articleApi from '@/api/article'
export default {
  data () {
    return {
      articleList:[],
      total: 0,
      pageSize: 10,
      currentPage: 1,
    }
  },
  created() {
    this.getArticlePageList(1);
  },
  methods:{
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      // console.log(`当前页: ${val}`);
      this.getArticlePageList(val);
    },
    // 查询轮播图数据
    getArticlePageList(currentPageValue) {
      let queryParams = {
        pageNum: currentPageValue,
        pageSize: 10,
      }
      articleApi.getArticlePageList(queryParams).then(response => {
        console.log(response.data.rows);
        this.articleList = response.data.rows
        this.total = response.data.total
      })
    },
    // 文章点击跳转
    articleItemClick(articleId) {
      this.$router.push({
        path: `/article/${articleId}`,
      })	
    }
  }
}
</script>
<style>
  .el-row {
    margin-left: 40px !important;
    margin-right: 40px !important;
  }
  .Community {
    width: 100%;
  }
  .Community .active-blog :hover  {
    background-color: #fafafa;
  }
  .Community-item-active {
    padding: 15px 10px 0;
  }
  .Community>div .Community-h-tag:hover span.blog-text {
    text-decoration: underline;
  }
  .Community>div a.Community-h-tag {
    margin-bottom: 10px;
  }
  .Community>div .Community-h-tag {
    font-size: 18px;
    font-weight: 500;
    color: #222226;
    overflow: hidden;
    white-space: normal;
    word-break: break-word;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    line-height: 25px;
  }
  .Community .Community-item {
    padding-bottom: 15px;
    border-bottom: 1px solid #f0f0f2;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: reverse;
    -ms-flex-flow: row-reverse;
    flex-flow: row-reverse;
  }
  .Community .Community-item .content {
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -ms-flex-direction: column;
    flex-direction: column;
    -webkit-box-pack: justify;
    -ms-flex-pack: justify;
    justify-content: space-between;
  }
  .Community .Community-item .content .desc {
    font-size: 14px;
    font-weight: 400;
    color: #555666;
    overflow: hidden;
    white-space: normal;
    word-break: break-word;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
  }
  .Community .Community-item .content .operation {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    margin-top: 14px;
    cursor: pointer;
  }
 .Community .Community-item .content .operation p {
    min-width: 22px;
    text-align: start;
    font-size: 14px;
    padding-right: 24px;
    color: #555666;
    line-height: 20px;
  }
  .Community .Community-item .content .operation .operation-b p img {
    height: 16px;
    cursor: pointer;
    margin-right: 4px;
  }
  .Community .Community-item .right {
    margin-right: 16px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: start;
    -ms-flex-align: start;
    align-items: flex-start;
    padding-top: 2px;
  }
  .Community .Community-item .right a {
    position: relative;
    border-radius: 2px;
    width: 134px;
    height: 84px;
    display: inline-block;
    background-size: cover;
    background-position: 50%;
    border: 1px solid #f5f6f7;
    overflow: hidden;
    background: #f5f6f7;
  }
  .Community .Community-item .right a .img {
    width: 100%;
    left: 50%;
    top: 50%;
    -webkit-transform: translate(-50%,-50%);
    transform: translate(-50%,-50%);
    height: auto;
    position: absolute;
  }
  .blog-slide-ad-box {
    padding: 18px;
    border: 1px solid #e8e8ed;
    margin-bottom: 16px;
  }
  .blog-slide-ad-box .small img{
    height: 100%;
    width: 100%;
    object-fit:contain;
  }
  .template {
    border-radius: 2px;
    border: 1px solid #e8e8ed;
    margin-bottom: 16px;
  }
  .template-title {
    height: 48px;
    padding: 0 24px;
    font-size: 18px;
    font-weight: 500;
    line-height: 48px;
    color: #222226;
    border-bottom: 1px solid #e8e8ed;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: justify;
    -ms-flex-pack: justify;
    justify-content: space-between;
  }
  .template-cont {
    padding: 10px 24px 10px;
  }
  .template .template-cont>a {
    font-size: 0;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: start;
    -ms-flex-align: start;
    align-items: flex-start;
  }
  .template .template-cont>a img {
    width: 100px;
    height: 58px;
    -o-object-fit: cover;
    object-fit: cover;
    border-radius: 2px;
    margin-right: 8px;
  }
  .template .template-cont>a p {
    margin-top: 6px;
    font-size: 14px;
    font-family: PingFang SC,Hiragino Sans GB,Arial,Microsoft YaHei,Verdana,Roboto,Noto,Helvetica Neue,sans-serif;
    font-weight: 400;
    color: #222226;
    line-height: 22px;
    -webkit-font-smoothing: antialiased;
    overflow: hidden;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    white-space: normal;
    word-break: break-word;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
  }
  a {
    cursor: pointer;
  }
  .block {
    float: right;
  }
</style>