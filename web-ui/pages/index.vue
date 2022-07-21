<template>
  <div class="app-container">
    <!-- 幻灯片 开始 -->
    <div v-swiper:mySwiper="swiperOption">
      <div class="swiper-wrapper">
          <div v-for="banner in bannerList" :key="banner.id" class="swiper-slide" style="background: #040B1B;">
              <a target="_blank" :href="banner.linkUrl">
                  <img :src="banner.imageUrl" :alt="banner.title">
              </a>
          </div>
      </div>
      <div class="swiper-pagination" slot="pagination"></div>
    </div>
    <!-- 幻灯片 结束 -->
    
    <div id="aCoursesList">
      <!-- 热门课程 开始 -->
      <div>
        <section class="container">
          <header class="comm-title">
            <h2 class="tac">
              <span class="c-333">热门课程</span>
            </h2>
          </header>
          <div>
            <article class="comm-course-list">
              <ul class="of" id="bna">
                <li v-for="course in eduList" :key="course.id">
                  <div class="cc-l-wrap">
                    <section class="course-img">
                      <img
                        :src="course.cover"
                        class="img-responsive"
                        :alt="course.title"
                      >
                      <div class="cc-mask">
                        <a href="#" title="开始观看" class="comm-btn c-btn-1">开始观看</a>
                      </div>
                    </section>
                    <h3 class="hLh30 txtOf mt10">
                      <a href="#" :title="course.title" class="course-title fsize18 c-333">{{course.title}}</a>
                    </h3>
                    <section class="mt10 hLh20 of">
                      <span class="fr jgTag bg-green" v-if="Number(course.price) === 0">
                        <i class="c-fff fsize12 f-fA">免费</i>
                      </span>
                      <span class="fl jgAttr c-ccc f-fA">
                        <i class="c-999 f-fA">9634人学习</i>
                        |
                        <i class="c-999 f-fA">9634评论</i>
                      </span>
                    </section>
                  </div>
                </li>
               
              </ul>
              <div class="clear"></div>
            </article>
            <section class="tac pt20">
              <a href="#" title="全部课程" class="comm-btn c-btn-2">全部课程</a>
            </section>
          </div>
        </section>
      </div>
      <!-- 热门课程 结束 -->
      <!-- 新上好课 开始 -->
      <div>
        <section class="container">
          <header class="comm-title">
            <h2 class="tac">
              <span class="c-333">新上好课</span>
            </h2>
          </header>
          <div>
            <article class="i-teacher-list">
              <ul class="of">
                <li v-for="teacher in teacherList" :key="teacher.id">
                  <section class="i-teach-wrap">
                    <div class="i-teach-pic">
                      <a href="/teacher/1" :title="teacher.name">
                        <img :alt="teacher.name" :src="teacher.avatar">
                      </a>
                    </div>
                    <div class="mt10 hLh30 txtOf tac">
                      <a href="/teacher/1" :title="teacher.name" class="fsize18 c-666">{{teacher.name}}</a>
                    </div>
                    <div class="hLh30 txtOf tac">
                      <span class="fsize14 c-999">{{teacher.career}}</span>
                    </div>
                    <div class="mt15 i-q-txt">
                      <p
                        class="c-999 f-fA"
                      >{{teacher.intro}}</p>
                    </div>
                  </section>
                </li>
                
              </ul>
              <div class="clear"></div>
            </article>
            <section class="tac pt20">
              <a href="#" title="全部课程" class="comm-btn c-btn-2">全部课程</a>
            </section>
          </div>
        </section>
      </div>
      <!-- 网校名师 结束 -->
    </div>
  </div>
</template>

<script>
import banner from '@/api/banner'
import index from '@/api/index'

export default {
  data () {
    return {
      swiperOption: {
        loop: true,
        autoplay: {
          delay: 3000,
          stopOnLastSlide: false,
          disableOnInteraction: false
        },
        //配置分页
        pagination: {
          el: '.swiper-pagination',//分页的dom节点
          clickable: true //允许分页点击跳转
        },
        // 设置点击箭头
        navigation: {
          nextEl: '.swiper-button-next',//下一页dom节点
          prevEl: '.swiper-button-prev'//前一页dom节点
        }
      },
      //banner数组
      bannerList:[
        {
          "id": 1,
          "linkUrl": "www.dragonwen.cn",
          "imageUrl": "https://www.gulixueyuan.com/files/system/2022/01-26/172605dc29fe231548.jpg?version=20.4.6",
          "title": "Flink性能调优"
        },
        {
          "id": 2,
          "linkUrl": "www.dragonwen.cn",
          "imageUrl": "https://www.gulixueyuan.com/files/system/2022/02-16/1502113c1947586168.jpg?version=20.4.6",
          "title": "Kafka3.0"
        },
        {
          "id": 3,
          "linkUrl": "www.dragonwen.cn",
          "imageUrl": "https://www.gulixueyuan.com/files/system/2021/12-29/171400881c0d537063.jpg?version=20.4.6",
          "title": "Canal数据实时同步神器"
        },
        {
          "id": 4,
          "linkUrl": "www.dragonwen.cn",
          "imageUrl": "https://www.gulixueyuan.com/files/system/2022/01-19/15375531895e994953.jpg?version=20.4.6",
          "title": "JavaWeb"
        }
      ],
      eduList:[],
      teacherList:[]
    }
  },
  created() {
    //调用查询banner的方法
    this.getBannerList()
    //调用查询热门课程和名师的方法
    this.getHotCourseTeacher()
  },
  methods:{
    //查询热门课程和名师
    getHotCourseTeacher() {
      index.getIndexData()
        .then(response => {
          this.eduList = response.data.data.eduList
          this.teacherList = response.data.data.teacherList
        })
    },
    //查询banner数据
    getBannerList() {
      banner.getListBanner()
        .then(response => {
          // this.bannerList = response.data.data.list
        })
    }
  }
}
</script>