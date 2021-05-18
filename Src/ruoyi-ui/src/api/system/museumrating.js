import request from '@/utils/request'

// 查询博物馆评分列表
export function listMuseumrating(query) {
  return request({
    url: '/system/museumrating/list',
    method: 'get',
    params: query
  })
}

// 查询博物馆评分详细
export function getMuseumrating(id) {
  return request({
    url: '/system/museumrating/' + id,
    method: 'get'
  })
}

// 新增博物馆评分
export function addMuseumrating(data) {
  return request({
    url: '/system/museumrating',
    method: 'post',
    data: data
  })
}

// 修改博物馆评分
export function updateMuseumrating(data) {
  return request({
    url: '/system/museumrating',
    method: 'put',
    data: data
  })
}

// 删除博物馆评分
export function delMuseumrating(id) {
  return request({
    url: '/system/museumrating/' + id,
    method: 'delete'
  })
}

// 导出博物馆评分
export function exportMuseumrating(query) {
  return request({
    url: '/system/museumrating/export',
    method: 'get',
    params: query
  })
}