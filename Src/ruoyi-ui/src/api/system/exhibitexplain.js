import request from '@/utils/request'

// 查询展览讲解列表
export function listExhibitexplain(query) {
  return request({
    url: '/system/exhibitexplain/list',
    method: 'get',
    params: query
  })
}

// 查询展览讲解详细
export function getExhibitexplain(id) {
  return request({
    url: '/system/exhibitexplain/' + id,
    method: 'get'
  })
}

// 新增展览讲解
export function addExhibitexplain(data) {
  return request({
    url: '/system/exhibitexplain',
    method: 'post',
    data: data
  })
}

// 修改展览讲解
export function updateExhibitexplain(data) {
  return request({
    url: '/system/exhibitexplain',
    method: 'put',
    data: data
  })
}

// 删除展览讲解
export function delExhibitexplain(id) {
  return request({
    url: '/system/exhibitexplain/' + id,
    method: 'delete'
  })
}

// 导出展览讲解
export function exportExhibitexplain(query) {
  return request({
    url: '/system/exhibitexplain/export',
    method: 'get',
    params: query
  })
}

export function getExhibitImage(id) {
  //return "/dev-api/system/exhibitexplain/select/pic/" + id;
  return "/prod-api/system/exhibitexplain/select/pic/" + id;
}

export function getExhibitVoice(id) {
  //return "/dev-api/system/exhibitexplain/select/voice/" + id;
  return "/prod-api/system/exhibitexplain/select/voice/" + id;
}
