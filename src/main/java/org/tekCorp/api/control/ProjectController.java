package org.tekCorp.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.tekCorp.api.domain.Project;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.repository.ProjectRepository;
import org.tekCorp.api.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
@RestController
@RequestMapping(value="/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected StatisticRepository statisticRepository;

    @RequestMapping
    public List<Project> listProject(){
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @RequestMapping(value = "/delete/{id}")
    public List<Project> deleteProject(@PathVariable("id") Integer id){
        projectRepository.delete(id);
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/view/{id}")
    public Project getProject(@PathVariable("id") Integer id){
        return projectRepository.findOne(id);
    }

    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public Project updateProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @RequestMapping(value = "/stat/")
    public HashMap<Project, ArrayList<Statistic>> getAllStat(){
        ArrayList<Project> listProject = (ArrayList<Project>) projectRepository.findAll();
        ArrayList<Statistic> listStat = (ArrayList<Statistic>) statisticRepository.findAll();

        HashMap<Project, ArrayList<Statistic>> mapStat = new HashMap<Project, ArrayList<Statistic>>();
        for (Statistic statistic : listStat){
            Project project = new Project();
            project.setIdProject(statistic.getId().getProjectId());

            project = listProject.get(listProject.indexOf(project));
            if (!mapStat.containsKey(project)){
                mapStat.put(project, new ArrayList<Statistic>());
            }

            mapStat.get(project).add(statistic);
        }

        return mapStat;
    }

    @RequestMapping(value = "/stat/{id}")
    public List<Statistic> getStatById(@PathVariable("id") Integer id){
        return statisticRepository.findByIdProjectId(id);
    }
}
