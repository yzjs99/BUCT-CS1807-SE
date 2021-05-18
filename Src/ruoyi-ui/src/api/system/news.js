import request from '@/utils/request'

// 查询新闻分析列表
export function listNews(query) {
  return request({
    url: '/system/news/list',
    method: 'get',
    params: query
  })
}

// 查询新闻分析详细
export function getNews(id) {
  return request({
    url: '/system/news/' + id,
    method: 'get'
  })
}

// 新增新闻分析
export function addNews(data) {
  return request({
    url: '/system/news',
    method: 'post',
    data: data
  })
}

// 修改新闻分析
export function updateNews(data) {
  return request({
    url: '/system/news',
    method: 'put',
    data: data
  })
}

// 删除新闻分析
export function delNews(id) {
  return request({
    url: '/system/news/' + id,
    method: 'delete'
  })
}

// 导出新闻分析
export function exportNews(query) {
  return request({
    url: '/system/news/export',
    method: 'get',
    params: query
  })
}