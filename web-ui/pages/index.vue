<template>
  <div class="app-container">
    <!-- 幻灯片 开始 -->
    <div v-swiper:mySwiper="swiperOption">
      <div class="swiper-wrapper">
        <div v-for="slideshow in slideshowList" :key="slideshow.slideshowId" class="swiper-slide" style="background: #040B1B;">
            <a :target="slideshow.target === '0' ? '_self' : '_blank'" :href="slideshow.linkUrl">
                <img :src="slideshow.slideshowImageUrl" :alt="slideshow.title">
            </a>
        </div>
      </div>
      <div class="swiper-pagination" slot="pagination"></div>
    </div>
    <!-- 幻灯片 结束 -->
    
    <div id="index-course-list">
      <!-- 热门课程 开始 -->
      <div>
        <section class="container">
          <header class="comm-title">
            <h2 class="index-course-module-title">
              <span class="c-333">热门课程</span>
            </h2>
            <a href="/course">查看全部</a>
          </header>
          <div>
            <article class="comm-course-list">
              <ul class="of" id="bna">
                <li v-for="course in hotCourseList" :key="course.id" @click="courseItemClick(course.id)">
                  <div class="cc-l-wrap">
                    <section class="course-img">
                      <img
                        :src="course.cover"
                        class="img-responsive"
                        :alt="course.title"
                      >
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
          </div>
        </section>
      </div>
      <!-- 热门课程 结束 -->
      <!-- 新上好课 开始 -->
      <div>
        <section class="container">
          <header class="comm-title">
            <h2 class="index-course-module-title">
              <span class="c-333">新上好课</span>
            </h2>
            <a href="/course">查看全部</a>
          </header>
          <div>
            <article class="comm-course-list">
              <ul class="of" id="bna">
                <li v-for="course in newCourseList" :key="course.id" @click="courseItemClick(course.id)">
                  <div class="cc-l-wrap">
                    <section class="course-img">
                      <img
                        :src="course.cover"
                        class="img-responsive"
                        :alt="course.title"
                      >
                      <div class="new-icon-text">
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
          </div>
        </section>
      </div>
      <!-- 新上好课 结束 -->
    </div>
  </div>
</template>

<script>
import indexApi from '@/api/index'

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
      // 轮播图数组数组
      slideshowList:[],
      hotCourseList:[
        {
          "id": 1,
          "cover": "https://www.gulixueyuan.com/files/course/2021/11-16/1504320cd58c775881.jpg",
          "title": "MySQL数据库",
          "price": 10
        },
        {
          "id": 2,
          "cover": "https://www.gulixueyuan.com/files/default/2018/06-15/0918251905f6057842.jpg",
          "title": "103集实战教学入门必备",
          "price": 20
        },
        {
          "id": 3,
          "cover": "https://www.gulixueyuan.com/files/default/2018/06-15/0918146150a9565117.jpg",
          "title": "103集实战教学入门必备",
          "price": 0
        },
        {
          "id": 4,
          "cover": "https://www.gulixueyuan.com/files/course/2021/08-02/151735f53563259871.png",
          "title": "2021全新SpringMVC框架教程",
          "price": 100
        },
        {
          "id": 5,
          "cover": "https://www.gulixueyuan.com/files/course/2020/05-22/09381798ce4f507296.jpg",
          "title": "尚硅谷Spring5视频教程",
          "price": 100
        },
        {
          "id": 6,
          "cover": "https://www.gulixueyuan.com/files/course/2020/12-14/09031863b67d915337.png",
          "title": "Vue3新特性",
          "price": 100
        },
        {
          "id": 7,
          "cover": "https://www.gulixueyuan.com/files/course/2021/04-19/1548193e32c7847193.jpg",
          "title": "2021最新Redis 6教程分布式锁，秒杀实战",
          "price": 200
        },
        {
          "id": 8,
          "cover": "https://www.gulixueyuan.com/files/course/2021/03-09/171418a0c26f812243.jpg",
          "title": "Java微服务+分布式+全栈项目【尚医通】",
          "price": 200
        },
        {
          "id": 9,
          "cover": "https://www.gulixueyuan.com/files/course/2020/09-17/092058a40481921036.jpg",
          "title": "Kubernetes（K8s）新版",
          "price": 200
        },
        {
          "id": 10,
          "cover": "https://www.gulixueyuan.com/files/course/2020/12-11/09261240947f704907.png",
          "title": "大数据项目之电商数仓3.0",
          "price": 200
        }
      ],
      newCourseList:[
        {
          "id": 1,
          "cover": "https://www.gulixueyuan.com/files/course/2021/11-16/1504320cd58c775881.jpg",
          "title": "MySQL数据库",
          "price": 10
        },
        {
          "id": 2,
          "cover": "https://www.gulixueyuan.com/files/default/2018/06-15/0918251905f6057842.jpg",
          "title": "103集实战教学入门必备",
          "price": 20
        },
        {
          "id": 3,
          "cover": "https://www.gulixueyuan.com/files/default/2018/06-15/0918146150a9565117.jpg",
          "title": "103集实战教学入门必备",
          "price": 0
        },
        {
          "id": 4,
          "cover": "https://www.gulixueyuan.com/files/course/2021/08-02/151735f53563259871.png",
          "title": "2021全新SpringMVC框架教程",
          "price": 100
        },
        {
          "id": 5,
          "cover": "https://www.gulixueyuan.com/files/course/2020/05-22/09381798ce4f507296.jpg",
          "title": "尚硅谷Spring5视频教程",
          "price": 100
        },
        {
          "id": 6,
          "cover": "https://www.gulixueyuan.com/files/course/2020/12-14/09031863b67d915337.png",
          "title": "Vue3新特性",
          "price": 100
        },
        {
          "id": 7,
          "cover": "https://www.gulixueyuan.com/files/course/2021/04-19/1548193e32c7847193.jpg",
          "title": "2021最新Redis 6教程分布式锁，秒杀实战",
          "price": 200
        },
        {
          "id": 8,
          "cover": "https://www.gulixueyuan.com/files/course/2021/03-09/171418a0c26f812243.jpg",
          "title": "Java微服务+分布式+全栈项目【尚医通】",
          "price": 200
        },
        {
          "id": 9,
          "cover": "https://www.gulixueyuan.com/files/course/2020/09-17/092058a40481921036.jpg",
          "title": "Kubernetes（K8s）新版",
          "price": 200
        },
        {
          "id": 10,
          "cover": "https://www.gulixueyuan.com/files/course/2020/12-11/09261240947f704907.png",
          "title": "大数据项目之电商数仓3.0",
          "price": 200
        }
      ],
    }
  },
  created() {
    // 调用查询轮播图的方法
    this.getSlideshowList()
    // 调用查询热门课程和新上好课的方法
    this.getHotNewCourse()
  },
  methods:{
    // 查询热门课程和新上好课
    getHotNewCourse() {
      indexApi.getIndexData().then(res => {
        // this.hotCourseList = res.data.data
        // this.newCourseList = res.data.data
      })
    },
    // 查询轮播图数据
    getSlideshowList() {
      indexApi.getSlideshowList().then(response => {
        this.slideshowList = response.data.data
      })
    },
    // 课程点击跳转
    courseItemClick(courseId) {
      this.$router.push({
        path: `/course/${courseId}`,
      })	
    }
  }
}
</script>