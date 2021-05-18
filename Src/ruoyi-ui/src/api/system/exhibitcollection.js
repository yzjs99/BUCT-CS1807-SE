import request from '@/utils/request'

// 查询展览——藏品列表
export function listExhibitcollection(query) {
  return request({
    url: '/system/exhibitcollection/list',
    method: 'get',
    params: query
  })
}

// 查询展览——藏品详细
export function getExhibitcollection(id) {
  return request({
    url: '/system/exhibitcollection/' + id,
    method: 'get'
  })
}

// 新增展览——藏品
export function addExhibitcollection(data) {
  return request({
    url: '/system/exhibitcollection',
    method: 'post',
    data: data
  })
}

// 修改展览——藏品
export function updateExhibitcollection(data) {
  return request({
    url: '/system/exhibitcollection',
    method: 'put',
    data: data
  })
}

// 删除展览——藏品
export function delExhibitcollection(id) {
  return request({
    url: '/system/exhibitcollection/' + id,
    method: 'delete'
  })
}

// 导出展览——藏品
export function exportExhibitcollection(query) {
  return request({
    url: '/system/exhibitcollection/export',
    method: 'get',
    params: query
  })
}