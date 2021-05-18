import request from '@/utils/request'

// 查询博物馆信息列表
export function listMuseum(query) {
  return request({
    url: '/system/museum/list',
    method: 'get',
    params: query
  })
}

// 查询博物馆信息详细
export function getMuseum(id) {
  return request({
    url: '/system/museum/' + id,
    method: 'get'
  })
}

// 新增博物馆信息
export function addMuseum(data) {
  return request({
    url: '/system/museum',
    method: 'post',
    data: data
  })
}

// 修改博物馆信息
export function updateMuseum(data) {
  return request({
    url: '/system/museum',
    method: 'put',
    data: data
  })
}

// 删除博物馆信息
export function delMuseum(id) {
  return request({
    url: '/system/museum/' + id,
    method: 'delete'
  })
}

// 导出博物馆信息
export function exportMuseum(query) {
  return request({
    url: '/system/museum/export',
    method: 'get',
    params: query
  })
}